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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustom;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("globalTiendaSeccionPorcentajeDesplazamientoV1")
@RequiredArgsConstructor
public class GlobalTiendaSeccionPorcentajeDesplazamientoV1RunAlgoritmo implements RunAlgoritmo {

  private static final Logger LOG = LoggerFactory.getLogger(GlobalTiendaSeccionPorcentajeDesplazamientoV1RunAlgoritmo.class);

  private final RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  private final TareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustom tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustom;

  private final TareaCalculoPersonaService tareaCalculoPersonaService;

  @Override
  public CompletableFuture<Void> execute(final RunTareaDto runTarea, final AlgoritmoDTO algoritmo) {
    GlobalTiendaSeccionPorcentajeDesplazamientoV1RunAlgoritmo.LOG.info(
        "Trabajo[{}]Tarea[{}] :: Inicio :: GlobalTiendaSeccionPorcentajeDesplazamientoV1RunAlgoritmo :: Ids",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId());
    final List<IdPersonaLocalDto> ids = this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustom
        .ids(algoritmo, runTarea.getTarea());
    GlobalTiendaSeccionPorcentajeDesplazamientoV1RunAlgoritmo.LOG.info(
        "Trabajo[{}]Tarea[{}] :: Fin :: GlobalTiendaSeccionPorcentajeDesplazamientoV1RunAlgoritmo :: Ids: {}",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), ids);

    final List<CompletableFuture<?>> cf = new ArrayList<>();

    for (final List<IdPersonaLocalDto> personas : StreamUtils.partition(
        ids,
        this.runAlgoritmoProperties.getCalculo().getBatchSize())) {
      AsyncUtils.checkAsyncAvaliable(cf, this.runAlgoritmoProperties.getCalculo().getThreadSize());

      GlobalTiendaSeccionPorcentajeDesplazamientoV1RunAlgoritmo.LOG.info(
          "Trabajo[{}]Tarea[{}] :: Inicio :: GlobalTiendaSeccionPorcentajeDesplazamientoV1RunAlgoritmo :: Personas: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
      try {
        final CompletableFuture<Void> cfCalc = this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustom
            .calcular(algoritmo,
                runTarea.getTarea(), personas);
        AsyncUtils.exceptionally(cfCalc, cf);

      } catch (final Exception e) {
        AsyncUtils.cancel(cf);
        GlobalTiendaSeccionPorcentajeDesplazamientoV1RunAlgoritmo.LOG.error(
            "Trabajo[{}]Tarea[{}] :: GlobalTiendaSeccionPorcentajeDesplazamientoV1RunAlgoritmo :: KO :: Personas: {}",
            runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size(), e);
        this.tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
            EstadoTareaCalculoPersonaEnum.KO.getDto());
      }
      GlobalTiendaSeccionPorcentajeDesplazamientoV1RunAlgoritmo.LOG.info(
          "Trabajo[{}]Tarea[{}] :: Fin :: GlobalTiendaSeccionPorcentajeDesplazamientoV1RunAlgoritmo :: Personas: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
    }
    AsyncUtils.waitAllOfIsOk(cf, cf);

    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public String getSqlCalcular(final AlgoritmoDTO algoritmo) {
    return this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustom
        .getSqlCalcular(algoritmo);
  }

}
