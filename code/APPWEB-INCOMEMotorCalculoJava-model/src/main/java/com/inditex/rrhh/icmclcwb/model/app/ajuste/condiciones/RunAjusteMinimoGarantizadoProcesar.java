package com.inditex.rrhh.icmclcwb.model.app.ajuste.condiciones;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.properties.dto.RunAjustePropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.async.ajustar.personas.CalculoAjusteMinimoGarantizadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjuste;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteMinimoGarantizadoRepositoryCustom;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RunAjusteMinimoGarantizadoProcesar implements RunAjuste {

  private static final Logger LOG = LoggerFactory.getLogger(RunAjusteMinimoGarantizadoProcesar.class);

  private final RunAjustePropertiesDto runAjusteProperties;

  private final TareaCalculoAjusteMinimoGarantizadoRepositoryCustom tareaCalculoAjusteMinimoGarantizadoRepositoryCustom;

  private final TareaCalculoPersonaService tareaCalculoPersonaService;

  private final CalculoAjusteMinimoGarantizadoAsyncService calculoAjusteMinimoGarantizadoAsyncService;

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void execute(final RunTareaDto runTarea, final AlgoritmoAjusteDto algoritmoAjuste) {
    RunAjusteMinimoGarantizadoProcesar.LOG.info(
        "Trabajo[{}]Tarea[{}] :: Inicio :: RunAjusteMinimoGarantizadoProcesar :: Ids",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId());
    final List<IdPersonaLocalDto> ids = this.tareaCalculoAjusteMinimoGarantizadoRepositoryCustom
        .ids(runTarea.getTarea());
    RunAjusteMinimoGarantizadoProcesar.LOG.info(
        "Trabajo[{}]Tarea[{}] :: Fin :: RunAjusteMinimoGarantizadoProcesar :: Ids: {}",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), ids);

    final List<CompletableFuture<?>> cf = new ArrayList<>();
    for (final List<IdPersonaLocalDto> personas : StreamUtils.partition(
        ids,
        this.runAjusteProperties.getAjuste().getBatchSize())) {
      AsyncUtils.checkAsyncAvaliable(cf, this.runAjusteProperties.getAjuste().getThreadSize());

      RunAjusteMinimoGarantizadoProcesar.LOG.info(
          "Trabajo[{}]Tarea[{}] :: Inicio :: RunAjusteMinimoGarantizadoProcesar :: Personas: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
      try {
        final CompletableFuture<Void> cfAjuste = this.calculoAjusteMinimoGarantizadoAsyncService
            .ajustar(
                algoritmoAjuste, runTarea.getTarea(),
                personas);
        AsyncUtils.exceptionally(cfAjuste, cf);
      } catch (final Exception e) {
        AsyncUtils.cancel(cf);
        RunAjusteMinimoGarantizadoProcesar.LOG.error("RunAjusteMinimoGarantizadoProcesar :: KO :: Personas: {}", personas.size(), e);
        this.tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
            EstadoTareaCalculoPersonaEnum.KO.getDto());
      }
      RunAjusteMinimoGarantizadoProcesar.LOG.info("Fin :: RunAjusteMinimoGarantizadoProcesar :: Personas: {}", personas.size());

      AsyncUtils.waitAllOfIsOk(cf, cf);
    }
  }

  @Override
  public String getSqlCalcular(final AlgoritmoAjusteDto algoritmoAjuste) {
    return this.tareaCalculoAjusteMinimoGarantizadoRepositoryCustom.getSqlAjustar(algoritmoAjuste);
  }

}
