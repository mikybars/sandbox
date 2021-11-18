package com.inditex.rrhh.icmclcwb.model.app.ajuste.condiciones;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.properties.dto.RunAjustePropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjuste;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTablePoliticasRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteMaximoGarantizadoRepositoryCustom;
import org.slf4j.Logger;

@Component("maximoGarantizadoV1")
public class RunAjusteMaximoGarantizadoProcesar implements RunAjuste {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("runAjusteProperties")
    private RunAjustePropertiesDto runAjusteProperties;

    @Autowired
    private TareaCalculoAjusteMaximoGarantizadoRepositoryCustom tareaCalculoAjusteMaximoGarantizadoRepositoryCustom;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Autowired
    private PrimaryTemporaryTablePoliticasRepositoryCustom primaryTemporaryTablePoliticasRepositoryCustom;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public CompletableFuture<Void> execute(final RunTareaDto runTarea, final AlgoritmoAjusteDto algoritmoAjuste) {
        this.log.info(
                "Trabajo[{}]Tarea[{}] :: Inicio :: RunAjusteMaximoGarantizadoProcesar :: Ids",
                runTarea.getTrabajo().getId(), runTarea.getTarea().getId());
        final List<IdPersonaLocalDto> ids = this.tareaCalculoAjusteMaximoGarantizadoRepositoryCustom
            .ids(runTarea.getTarea());
        this.log.info(
                "Trabajo[{}]Tarea[{}] :: Fin :: RunAjusteMaximoGarantizadoProcesar :: Ids: {}",
                runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), ids);

        final List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            this.primaryTemporaryTablePoliticasRepositoryCustom.createTempAusenciasDateMaximoGarantizado();
            this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempAusenciasDateMaximoGarantizado();
            this.primaryTemporaryTablePoliticasRepositoryCustom
                .insertTempAusenciasDateMaximoGarantizado(runTarea.getTarea());
            this.primaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoConAjusteMaximoGarantizado();
            this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempCalculoConAjusteMaximoGarantizado();
            this.primaryTemporaryTablePoliticasRepositoryCustom
                .insertTempCalculoConAjusteMaximoGarantizado(runTarea.getTarea());
            this.primaryTemporaryTablePoliticasRepositoryCustom.createTempDatosMaximoGarantizado();
            this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempDatosMaximoGarantizado();
            this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempDatosMaximoGarantizado(runTarea.getTarea());

            for (final List<IdPersonaLocalDto> personas : StreamUtils.partition(
                    ids,
                    this.runAjusteProperties.getAjuste().getBatchSize())) {
                AsyncUtils.checkAsyncAvaliable(cf, this.runAjusteProperties.getAjuste().getThreadSize());

                this.log.info(
                        "Trabajo[{}]Tarea[{}] :: Inicio :: RunAjusteMaximoGarantizadoProcesar :: Personas: {}",
                        runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
                try {
                    final CompletableFuture<Void> cfAjuste = this.tareaCalculoAjusteMaximoGarantizadoRepositoryCustom
                        .ajustar(
                                algoritmoAjuste, runTarea.getTarea(),
                                personas);
                    AsyncUtils.exceptionally(cfAjuste, cf);
                } catch (final Exception e) {
                    AsyncUtils.cancel(cf);
                    this.log.error("RunAjusteMaximoGarantizadoProcesar :: KO :: Personas: {}", personas.size(), e);
                    this.tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
                            EstadoTareaCalculoPersonaEnum.KO.getDto());
                }
                this.log.info("Fin :: RunAjusteMaximoGarantizadoProcesar :: Personas: {}", personas.size());

            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } finally {
            this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempAusenciasDateMaximoGarantizado();
            this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoConAjusteMaximoGarantizado();
            this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempDatosMaximoGarantizado();
        }
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public String getSqlCalcular(final AlgoritmoAjusteDto algoritmoAjuste) {
        return this.tareaCalculoAjusteMaximoGarantizadoRepositoryCustom.getSqlAjustar(algoritmoAjuste);
    }

}
