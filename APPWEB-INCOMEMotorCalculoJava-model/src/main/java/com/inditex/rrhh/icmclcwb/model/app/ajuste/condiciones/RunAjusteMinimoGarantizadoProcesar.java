package com.inditex.rrhh.icmclcwb.model.app.ajuste.condiciones;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteMinimoGarantizadoRepositoryCustom;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component("minimoGarantizadoV1")
public class RunAjusteMinimoGarantizadoProcesar implements RunAjuste {

  @Autowired
  private Logger log;

  @Autowired
  @Qualifier("runAjusteProperties")
  private RunAjustePropertiesDto runAjusteProperties;

  @Autowired
  private TareaCalculoAjusteMinimoGarantizadoRepositoryCustom tareaCalculoAjusteMinimoGarantizadoRepositoryCustom;

  @Autowired
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Autowired
  private PrimaryTemporaryTablePoliticasRepositoryCustom primaryTemporaryTablePoliticasRepositoryCustom;

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public CompletableFuture<Void> execute(final RunTareaDto runTarea, final AlgoritmoAjusteDto algoritmoAjuste) {
    this.log.info(
        "Trabajo[{}]Tarea[{}] :: Inicio :: RunAjusteMinimoGarantizadoProcesar :: Ids",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId());
    final List<IdPersonaLocalDto> ids = this.tareaCalculoAjusteMinimoGarantizadoRepositoryCustom
        .ids(runTarea.getTarea());
    this.log.info(
        "Trabajo[{}]Tarea[{}] :: Fin :: RunAjusteMinimoGarantizadoProcesar :: Ids: {}",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), ids);

    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      this.primaryTemporaryTablePoliticasRepositoryCustom.createTempAusenciasDateMinimoGarantizado();
      this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempAusenciasDateMinimoGarantizado();
      this.primaryTemporaryTablePoliticasRepositoryCustom
          .insertTempAusenciasDateMinimoGarantizado(runTarea.getTarea());
      this.primaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoConAjusteMinimoGarantizado();
      this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempCalculoConAjusteMinimoGarantizado();
      this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoConAjusteMinimoGarantizado(
          runTarea.getTarea());
      this.primaryTemporaryTablePoliticasRepositoryCustom.createTempDatosMinimoGarantizado();
      this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempDatosMinimoGarantizado();
      this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempDatosMininimoGarantizado(runTarea.getTarea());

      for (final List<IdPersonaLocalDto> personas : StreamUtils.partition(
          ids,
          this.runAjusteProperties.getAjuste().getBatchSize())) {
        AsyncUtils.checkAsyncAvaliable(cf, this.runAjusteProperties.getAjuste().getThreadSize());

        this.log.info(
            "Trabajo[{}]Tarea[{}] :: Inicio :: RunAjusteMinimoGarantizadoProcesar :: Personas: {}",
            runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
        try {
          final CompletableFuture<Void> cfAjuste = this.tareaCalculoAjusteMinimoGarantizadoRepositoryCustom
              .ajustar(
                  algoritmoAjuste, runTarea.getTarea(),
                  personas);
          AsyncUtils.exceptionally(cfAjuste, cf);
        } catch (final Exception e) {
          AsyncUtils.cancel(cf);
          this.log.error("RunAjusteMinimoGarantizadoProcesar :: KO :: Personas: {}", personas.size(), e);
          this.tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
              EstadoTareaCalculoPersonaEnum.KO.getDto());
        }
        this.log.info("Fin :: RunAjusteMinimoGarantizadoProcesar :: Personas: {}", personas.size());

      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } finally {
      this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempAusenciasDateMinimoGarantizado();
      this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoConAjusteMinimoGarantizado();
      this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempDatosMinimoGarantizado();
    }
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public String getSqlCalcular(final AlgoritmoAjusteDto algoritmoAjuste) {
    return this.tareaCalculoAjusteMinimoGarantizadoRepositoryCustom.getSqlAjustar(algoritmoAjuste);
  }

}
