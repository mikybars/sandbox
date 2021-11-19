package com.inditex.rrhh.icmclcwb.model.app.ajuste.condiciones;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteAntiguedadRepositoryCustom;
import org.slf4j.Logger;

@Component("antiguedadV1")
public class RunAjusteAntiguedadProcesar implements RunAjuste {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("runAjusteProperties")
    private RunAjustePropertiesDto runAjusteProperties;

    @Autowired
    private TareaCalculoAjusteAntiguedadRepositoryCustom tareaCalculoAjusteAntiguedadRepositoryCustom;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Autowired
    private PrimaryTemporaryTablePoliticasRepositoryCustom primaryTemporaryTablePoliticasRepositoryCustom;

    @Override
    public CompletableFuture<Void> execute(final RunTareaDto runTarea, final AlgoritmoAjusteDto algoritmoAjuste) {
        this.log.info(
                "Trabajo[{}]Tarea[{}] :: Inicio :: RunAjusteAntiguedadProcesar :: Ids",
                runTarea.getTrabajo().getId(), runTarea.getTarea().getId());
        final List<IdPersonaLocalDto> ids = this.tareaCalculoAjusteAntiguedadRepositoryCustom
            .ids(runTarea.getTarea());
        this.log.info(
                "Trabajo[{}]Tarea[{}] :: Fin :: RunAjusteAntiguedadProcesar :: Ids: {}",
                runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), ids);

        final List<CompletableFuture<?>> cf = new ArrayList<>();
        /*
         * try { // Creación de tablas temporales y sus índices para la baja it
         * this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAntiguedad();
         * this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempFechasAntiguedad();
         * this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasAntiguedad();
         * this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempFechasAcumuladasAntiguedad();
         *
         * // Inserción en tablas temporales
         * this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad(runTarea.getTarea(
         * )); this.primaryTemporaryTablePoliticasRepositoryCustom
         * .insertTempFechasAcumuladasAntiguedad(runTarea.getTarea());
         */
        for (final List<IdPersonaLocalDto> personas : StreamUtils.partition(
                ids,
                this.runAjusteProperties.getAjuste().getBatchSize())) {
            AsyncUtils.checkAsyncAvaliable(cf, this.runAjusteProperties.getAjuste().getThreadSize());

            this.log.info(
                    "Trabajo[{}]Tarea[{}] :: Inicio :: RunAjusteAntiguedadProcesar :: Personas: {}",
                    runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
            try {
                final CompletableFuture<Void> cfAjuste = this.tareaCalculoAjusteAntiguedadRepositoryCustom
                    .ajustar(
                            algoritmoAjuste, runTarea.getTarea(),
                            personas);
                AsyncUtils.exceptionally(cfAjuste, cf);
            } catch (final Exception e) {
                AsyncUtils.cancel(cf);
                this.log.error("RunAjusteAntiguedadProcesar :: KO :: Personas: {}", personas.size(), e);
                this.tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
                        EstadoTareaCalculoPersonaEnum.KO.getDto());
            }
            this.log.info("Fin :: RunAjusteAntiguedadProcesar :: Personas: {}", personas.size());

        }
        AsyncUtils.waitAllOfIsOk(cf, cf);
        /*
         * } finally { this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAntiguedad();
         * this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasAntiguedad(); }
         */
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public String getSqlCalcular(final AlgoritmoAjusteDto algoritmoAjuste) {
        return this.tareaCalculoAjusteAntiguedadRepositoryCustom.getSqlAjustar(algoritmoAjuste);
    }

}
