package com.inditex.rrhh.icmclcwb.model.app.ajuste.condiciones;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.properties.dto.RunAjustePropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.async.ajustar.personas.CalculoAjusteVacacionesAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjuste;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteVacacionesRepositoryCustom;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RunAjusteVacacionesProcesar implements RunAjuste {

  @Autowired
  private Logger log;

  @Autowired
  @Qualifier("runAjusteProperties")
  private RunAjustePropertiesDto runAjusteProperties;

  @Autowired
  private TareaCalculoAjusteVacacionesRepositoryCustom tareaCalculoAjusteVacacionesRepositoryCustom;

  @Autowired
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Autowired
  private CalculoAjusteVacacionesAsyncService calculoAjusteVacacionesAsyncService;

  @Override
  public void execute(final RunTareaDto runTarea, final AlgoritmoAjusteDto algoritmoAjuste) {
    this.log.info(
        "Trabajo[{}]Tarea[{}] :: Inicio :: RunAjusteVacacionesProcesar :: Ids",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId());
    final List<IdPersonaLocalDto> ids = this.tareaCalculoAjusteVacacionesRepositoryCustom.ids(runTarea.getTarea());
    this.log.info(
        "Trabajo[{}]Tarea[{}] :: Fin :: RunAjusteVacacionesProcesar :: Ids: {}",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), ids);

    final List<CompletableFuture<?>> cf = new ArrayList<>();

    for (final List<IdPersonaLocalDto> personas : StreamUtils.partition(
        ids,
        this.runAjusteProperties.getAjuste().getBatchSize())) {
      AsyncUtils.checkAsyncAvaliable(cf, this.runAjusteProperties.getAjuste().getThreadSize());

      this.log.info(
          "Trabajo[{}]Tarea[{}] :: Inicio :: RunAjusteVacacionesProcesar :: Personas: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
      try {
        final CompletableFuture<Void> cfAjuste = this.calculoAjusteVacacionesAsyncService.ajustar(
            algoritmoAjuste, runTarea.getTarea(),
            personas);
        AsyncUtils.exceptionally(cfAjuste, cf);
      } catch (final Exception e) {
        AsyncUtils.cancel(cf);
        this.log.error("RunAjusteVacacionesProcesar :: KO :: Personas: {}", personas.size(), e);
        this.tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
            EstadoTareaCalculoPersonaEnum.KO.getDto());
      }
      this.log.info("Fin :: RunAjusteVacacionesProcesar :: Personas: {}", personas.size());

      AsyncUtils.waitAllOfIsOk(cf, cf);
    }
  }

  @Override
  public String getSqlCalcular(final AlgoritmoAjusteDto algoritmoAjuste) {
    return this.tareaCalculoAjusteVacacionesRepositoryCustom.getSqlAjustar(algoritmoAjuste);
  }

}
