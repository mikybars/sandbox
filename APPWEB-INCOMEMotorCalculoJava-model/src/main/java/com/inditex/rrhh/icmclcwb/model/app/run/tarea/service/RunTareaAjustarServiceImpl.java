package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.properties.dto.RunAjustePropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Validation;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.AlgoritmoAjusteService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaAjustarService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraPoliticaService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjusteFactory;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTablePoliticasRepositoryCustom;

import com.inditex.aqsw.framework.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.aqsw.framework.common.metrics.annotation.TimerFunctionalMetric;

@Service
@Validated
public class RunTareaAjustarServiceImpl implements RunTareaAjustarService {

    @Autowired
    @Qualifier("runAjusteProperties")
    private RunAjustePropertiesDto runAjusteProperties;

    @Autowired
    private AlgoritmoAjusteService algoritmoAjusteService;

    @Autowired
    private RunAjusteFactory runAjusteFactory;

    @Autowired
    private TareaFaseService tareaFaseService;

    @Autowired
    private TareaPersonaEstructuraPoliticaService tareaPersonaEstructuraPoliticaService;

    @Autowired
    private PrimaryTemporaryTablePoliticasRepositoryCustom primaryTemporaryTablePoliticasRepositoryCustom;

    @Auditoria
    @Validation(fase = 7)
    @TimerFunctionalMetric(metricName = "RunTareaAjustarService.run.timer",
            metricGroupName = "RunTareaAjustarServiceGroup", metricDescription = "RunTareaAjustarService.run.timer")
    @CounterFunctionalMetric(metricName = "RunTareaAjustarService.run.counter",
            metricGroupName = "RunTareaAjustarServiceGroup", metricDescription = "RunTareaAjustarService.run.counter")
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        this.tareaFaseService.updateFechaInicio(
                this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
                        FaseEnum.AJUSTAR.getId()));
        final TareaDto tarea = runTarea.getTarea();
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            this.createMaxMinGarantizadoTemporaryTables(tarea);
            for (final Long pesos : this.algoritmoAjusteService.customFindAjustePesosByTarea(tarea.getId())) {
                for (final Integer id : this.algoritmoAjusteService.customFindAjusteIdsByTareaAndPeso(tarea.getId(),
                        pesos)) {
                    AsyncUtils.checkAsyncAvaliable(cf, this.runAjusteProperties.getThreadSize());
                    final AlgoritmoAjusteDto algoritmo = this.algoritmoAjusteService.findById(id);
                    final CompletableFuture<Void> cfRun = this.runAjusteFactory.getRunAjuste(algoritmo.getNombre())
                        .execute(runTarea, algoritmo);
                    AsyncUtils.exceptionally(cfRun, cf);
                }
                AsyncUtils.waitAllOfIsOk(cf, cf);
            }
        } finally {
            this.deleteMaxMinGarantizadoTemporaryTables(tarea);
        }

        this.tareaFaseService.updateFechaFinAndEstado(
                this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
                        FaseEnum.AJUSTAR.getId()),
                EstadoTareaFaseEnum.OK.getDto());
    }

    /**
     * Este método crea las tablas temporales comunes de Máximo Garantizado y Mínimo Garantizado, así
     * como sus índices y las llena de datos
     */
    protected void createMaxMinGarantizadoTemporaryTables(final TareaDto tarea) {
        if (Boolean.TRUE.equals(this.tareaPersonaEstructuraPoliticaService.existePolitica(tarea,
                Arrays.asList(TipoPoliticaEnum.MINIMO_GARANTIZADO, TipoPoliticaEnum.MAXIMO_GARANTIZADO)))) {
            this.primaryTemporaryTablePoliticasRepositoryCustom.createTempAusenciasDateMaxMinGarantizado();
            this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempAusenciasDateMaxGarantizado();
            this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempAusenciasDateMinGarantizado();
            this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempAusenciasDateMaxMinGarantizado(tarea);
            this.primaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoConAjusteMaxMinGarantizado();
            this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempCalculoConAjusteMaxMinGarantizado();
            this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoConAjusteMaxMinGarantizado(tarea);
            this.primaryTemporaryTablePoliticasRepositoryCustom.createTempDatosMaxMinGarantizado();
            this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempDatosMaxMinGarantizado();
        }
    }

    /**
     * Este método borra las tablas temporales comunes de Máximo Garantizado y Mínimo Garantizado
     */
    protected void deleteMaxMinGarantizadoTemporaryTables(final TareaDto tarea) {
        if (Boolean.TRUE.equals(this.tareaPersonaEstructuraPoliticaService.existePolitica(tarea,
                Arrays.asList(TipoPoliticaEnum.MINIMO_GARANTIZADO, TipoPoliticaEnum.MAXIMO_GARANTIZADO)))) {
            this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempAusenciasDateMaxMinGarantizado();
            this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoConAjusteMaxMinGarantizado();
            this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempDatosMaxMinGarantizado();
        }
    }

}
