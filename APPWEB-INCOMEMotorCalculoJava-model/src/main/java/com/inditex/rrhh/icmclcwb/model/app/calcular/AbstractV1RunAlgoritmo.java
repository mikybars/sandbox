package com.inditex.rrhh.icmclcwb.model.app.calcular;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoBaseRepositoryCustom;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractV1RunAlgoritmo implements RunAlgoritmo {

  @Autowired
  private Logger log;

  @Autowired
  @Qualifier("runAlgoritmoProperties")
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @Autowired
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  protected abstract TareaCalculoAlgoritmoBaseRepositoryCustom getTareaCalculoAlgoritmoRespositoryCustom();

  protected abstract String getAlgoritmoName();

  @Override
  public String getSqlCalcular(final AlgoritmoDTO algoritmo) {
    return this.getTareaCalculoAlgoritmoRespositoryCustom().getSqlCalcular(algoritmo);
  }

  @Override
  public CompletableFuture<Void> execute(final RunTareaDto runTarea,
      final AlgoritmoDTO algoritmo) {
    this.log.info("Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Ids",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), this.getAlgoritmoName());
    final List<IdPersonaLocalDto> ids = this.getTareaCalculoAlgoritmoRespositoryCustom()
        .ids(algoritmo, runTarea.getTarea());
    this.log.info("Trabajo[{}]Tarea[{}] :: Fin :: {} :: Ids: {}",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), this.getAlgoritmoName(), ids);

    final List<CompletableFuture<?>> cf = new ArrayList<>();

    for (final List<IdPersonaLocalDto> personas : StreamUtils.partition(
        ids,
        this.runAlgoritmoProperties.getCalculo().getBatchSize())) {
      AsyncUtils.checkAsyncAvaliable(cf, this.runAlgoritmoProperties.getCalculo().getThreadSize());

      this.log.info("Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Personas: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), this.getAlgoritmoName(), personas.size());
      try {
        final CompletableFuture<Void> cfCalc = this.getTareaCalculoAlgoritmoRespositoryCustom()
            .calcular(algoritmo,
                runTarea.getTarea(), personas);
        AsyncUtils.exceptionally(cfCalc, cf);

      } catch (final Exception e) {
        AsyncUtils.cancel(cf);
        this.log.error("Trabajo[{}]Tarea[{}] :: {} :: KO :: Personas: {}",
            runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), this.getAlgoritmoName(), personas.size(), e);
        this.tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
            EstadoTareaCalculoPersonaEnum.KO.getDto());
      }
      this.log.info("Trabajo[{}]Tarea[{}] :: Fin :: {} :: Personas: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), this.getAlgoritmoName(), personas.size());
    }
    AsyncUtils.waitAllOfIsOk(cf, cf);

    return CompletableFuture.completedFuture(AsyncConstants.NIL);

  }
}
