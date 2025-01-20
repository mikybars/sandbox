package com.inditex.rrhh.icmclcwb.model.app.ajuste.condiciones;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.properties.dto.RunAjustePropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.async.ajustar.personas.CalculoAjusteBajaItAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjuste;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteBajaItRepositoryCustom;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RunAjusteBajaItProcesar implements RunAjuste {

  private static final Logger LOG = LoggerFactory.getLogger(RunAjusteBajaItProcesar.class);

  private final RunAjustePropertiesDto runAjusteProperties;

  private final TareaCalculoAjusteBajaItRepositoryCustom tareaCalculoAjusteBajaItRepositoryCustom;

  private final TareaCalculoPersonaService tareaCalculoPersonaService;

  private final CalculoAjusteBajaItAsyncService calculoAjusteBajaItAsyncService;

  @Override
  public void execute(final RunTareaDto runTarea, final AlgoritmoAjusteDto algoritmoAjuste) {
    RunAjusteBajaItProcesar.LOG.info(
        "Trabajo[{}]Tarea[{}] :: Inicio :: RunAjusteBajaItProcesar :: Ids",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId());
    final List<IdPersonaLocalDto> ids = this.tareaCalculoAjusteBajaItRepositoryCustom
        .ids(runTarea.getTarea());
    RunAjusteBajaItProcesar.LOG.info(
        "Trabajo[{}]Tarea[{}] :: Fin :: RunAjusteBajaItProcesar :: Ids: {}",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), ids);

    final List<CompletableFuture<?>> cf = new ArrayList<>();

    for (final List<IdPersonaLocalDto> personas : StreamUtils.partition(
        ids,
        this.runAjusteProperties.getAjuste().getBatchSize())) {
      AsyncUtils.checkAsyncAvaliable(cf, this.runAjusteProperties.getAjuste().getThreadSize());

      RunAjusteBajaItProcesar.LOG.info(
          "Trabajo[{}]Tarea[{}] :: Inicio :: RunAjusteBajaItProcesar :: Personas: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
      try {
        final CompletableFuture<Void> cfAjuste = this.calculoAjusteBajaItAsyncService
            .ajustar(algoritmoAjuste, runTarea.getTarea(), personas);
        AsyncUtils.exceptionally(cfAjuste, cf);
      } catch (final Exception e) {
        AsyncUtils.cancel(cf);
        RunAjusteBajaItProcesar.LOG.error("RunAjusteBajaItProcesar :: KO :: Personas: {}", personas.size(), e);
        this.tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
            EstadoTareaCalculoPersonaEnum.KO.getDto());
      }
      RunAjusteBajaItProcesar.LOG.info("Fin :: RunAjusteBajaItProcesar :: Personas: {}", personas.size());

    }
    AsyncUtils.waitAllOfIsOk(cf, cf);
  }

  @Override
  public String getSqlCalcular(final AlgoritmoAjusteDto algoritmoAjuste) {
    return this.tareaCalculoAjusteBajaItRepositoryCustom.getSqlAjustar(algoritmoAjuste);
  }

}
