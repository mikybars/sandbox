package com.inditex.rrhh.icmclcwb.model.app.ajuste.condiciones;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.properties.dto.RunAjustePropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.async.ajustar.personas.CalculoAjusteCarenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjuste;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteCarenciaRepositoryCustom;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RunAjusteCarenciaProcesar implements RunAjuste {

  private static final Logger LOG = LoggerFactory.getLogger(RunAjusteCarenciaProcesar.class);

  private final RunAjustePropertiesDto runAjusteProperties;

  private final CalculoAjusteCarenciaAsyncService calculoAjusteCarenciaAsyncService;

  private final TareaCalculoAjusteCarenciaRepositoryCustom tareaCalculoAjusteCarenciaRepositoryCustom;

  private final TareaCalculoPersonaService tareaCalculoPersonaService;

  @Override
  public void execute(final RunTareaDto runTarea, final AlgoritmoAjusteDto algoritmoAjuste) {
    final TareaDto tarea = runTarea.getTarea();
    RunAjusteCarenciaProcesar.LOG.info(
        "Trabajo[{}]Tarea[{}] :: Inicio :: RunAjusteCarenciaProcesar :: Ids",
        runTarea.getTrabajo().getId(), tarea.getId());
    final List<IdPersonaLocalDto> ids = this.tareaCalculoAjusteCarenciaRepositoryCustom
        .ids(tarea);
    RunAjusteCarenciaProcesar.LOG.info(
        "Trabajo[{}]Tarea[{}] :: Fin :: RunAjusteCarenciaProcesar :: Ids: {}",
        runTarea.getTrabajo().getId(), tarea.getId(), ids);

    final List<CompletableFuture<?>> cf = new ArrayList<>();

    for (final List<IdPersonaLocalDto> personas : StreamUtils.partition(
        ids,
        this.runAjusteProperties.getAjuste().getBatchSize())) {
      AsyncUtils.checkAsyncAvaliable(cf, this.runAjusteProperties.getAjuste().getThreadSize());

      RunAjusteCarenciaProcesar.LOG.info(
          "Trabajo[{}]Tarea[{}] :: Inicio :: RunAjusteCarenciaProcesar :: Personas: {}",
          runTarea.getTrabajo().getId(), tarea.getId(), personas.size());
      try {
        final CompletableFuture<Void> cfAjuste = this.calculoAjusteCarenciaAsyncService
            .ajustar(
                algoritmoAjuste, tarea,
                personas);
        AsyncUtils.exceptionally(cfAjuste, cf);
      } catch (final Exception e) {
        AsyncUtils.cancel(cf);
        RunAjusteCarenciaProcesar.LOG.error("RunAjusteCarenciaProcesar :: KO :: Personas: {}", personas.size(), e);
        this.tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
            EstadoTareaCalculoPersonaEnum.KO.getDto());
      }
      RunAjusteCarenciaProcesar.LOG.info("Fin :: RunAjusteCarenciaProcesar :: Personas: {}", personas.size());

      AsyncUtils.waitAllOfIsOk(cf, cf);
    }
  }

  @Override
  public String getSqlCalcular(final AlgoritmoAjusteDto algoritmoAjuste) {
    return this.tareaCalculoAjusteCarenciaRepositoryCustom.getSqlAjustar(algoritmoAjuste);
  }

}
