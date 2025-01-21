package com.inditex.rrhh.icmclcwb.model.app.calcular.globaltiendaseccion.v1;

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
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDiariaDesplazamientoV1RepositoryCustom;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("globalTiendaSeccionPorcentajeDiariaDesplazamientoV1")
@RequiredArgsConstructor
public class GlobalTiendaSeccionPorcentajeDiariaDesplazamientoV1RunAlgoritmo implements RunAlgoritmo {

  private static final Logger LOG = LoggerFactory.getLogger(GlobalTiendaSeccionPorcentajeDiariaDesplazamientoV1RunAlgoritmo.class);

  private final RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  private final TareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDiariaDesplazamientoV1RepositoryCustom tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDiariaDesplazamientoV1RepositoryCustom;

  private final TareaCalculoPersonaService tareaCalculoPersonaService;

  @Override
  public CompletableFuture<Void> execute(final RunTareaDto runTarea, final AlgoritmoDTO algoritmo) {
    GlobalTiendaSeccionPorcentajeDiariaDesplazamientoV1RunAlgoritmo.LOG.info(
        "Trabajo[{}]Tarea[{}] :: Inicio :: GlobalTiendaSeccionPorcentajeDiariaDesplazamientoV1RunAlgoritmo :: Ids",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId());
    final List<IdPersonaLocalDto> ids = this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDiariaDesplazamientoV1RepositoryCustom
        .ids(algoritmo, runTarea.getTarea());
    GlobalTiendaSeccionPorcentajeDiariaDesplazamientoV1RunAlgoritmo.LOG.info(
        "Trabajo[{}]Tarea[{}] :: Fin :: GlobalTiendaSeccionPorcentajeDiariaDesplazamientoV1RunAlgoritmo :: Ids: {}",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), ids);

    final List<CompletableFuture<?>> cf = new ArrayList<>();

    for (final List<IdPersonaLocalDto> personas : StreamUtils.partition(
        ids,
        this.runAlgoritmoProperties.getCalculo().getBatchSize())) {
      AsyncUtils.checkAsyncAvaliable(cf, this.runAlgoritmoProperties.getCalculo().getThreadSize());

      GlobalTiendaSeccionPorcentajeDiariaDesplazamientoV1RunAlgoritmo.LOG.info(
          "Trabajo[{}]Tarea[{}] :: Inicio :: GlobalTiendaSeccionPorcentajeDiariaDesplazamientoV1RunAlgoritmo :: Personas: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
      try {
        final CompletableFuture<Void> cfCalc = this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDiariaDesplazamientoV1RepositoryCustom
            .calcular(algoritmo,
                runTarea.getTarea(), personas);
        AsyncUtils.exceptionally(cfCalc, cf);

      } catch (final Exception e) {
        AsyncUtils.cancel(cf);
        GlobalTiendaSeccionPorcentajeDiariaDesplazamientoV1RunAlgoritmo.LOG.error(
            "Trabajo[{}]Tarea[{}] :: GlobalTiendaSeccionPorcentajeDiariaDesplazamientoV1RunAlgoritmo :: KO :: Personas: {}",
            runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size(), e);
        this.tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
            EstadoTareaCalculoPersonaEnum.KO.getDto());
      }
      GlobalTiendaSeccionPorcentajeDiariaDesplazamientoV1RunAlgoritmo.LOG.info(
          "Trabajo[{}]Tarea[{}] :: Fin :: GlobalTiendaSeccionPorcentajeDiariaDesplazamientoV1RunAlgoritmo :: Personas: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
    }
    AsyncUtils.waitAllOfIsOk(cf, cf);

    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public String getSqlCalcular(final AlgoritmoDTO algoritmo) {
    return this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDiariaDesplazamientoV1RepositoryCustom
        .getSqlCalcular(algoritmo);
  }

}
