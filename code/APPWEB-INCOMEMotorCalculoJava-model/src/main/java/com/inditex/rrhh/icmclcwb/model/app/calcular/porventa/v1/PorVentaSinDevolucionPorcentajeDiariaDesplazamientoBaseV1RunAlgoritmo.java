package com.inditex.rrhh.icmclcwb.model.app.calcular.porventa.v1;

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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("porVentaSinDevolucionPorcentajeDiariaDesplazamientoBaseV1")
@RequiredArgsConstructor
public class PorVentaSinDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo implements RunAlgoritmo {

  private static final Logger LOG = LoggerFactory.getLogger(PorVentaSinDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo.class);

  private final RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  private final TareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom;

  private final TareaCalculoPersonaService tareaCalculoPersonaService;

  @Override
  public CompletableFuture<Void> execute(final RunTareaDto runTarea, final AlgoritmoDTO algoritmo) {
    PorVentaSinDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo.LOG.info(
        "Trabajo[{}]Tarea[{}] :: Inicio :: PorVentaSinDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo :: Ids",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId());
    final List<IdPersonaLocalDto> ids = this.tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .ids(algoritmo, runTarea.getTarea());
    PorVentaSinDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo.LOG.info(
        "Trabajo[{}]Tarea[{}] :: Fin :: PorVentaSinDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo :: Ids: {}",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), ids);

    final List<CompletableFuture<?>> cf = new ArrayList<>();

    for (final List<IdPersonaLocalDto> personas : StreamUtils.partition(
        ids,
        this.runAlgoritmoProperties.getCalculo().getBatchSize())) {
      AsyncUtils.checkAsyncAvaliable(cf, this.runAlgoritmoProperties.getCalculo().getThreadSize());

      PorVentaSinDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo.LOG.info(
          "Trabajo[{}]Tarea[{}] :: Inicio :: PorVentaSinDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo :: Personas: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
      try {
        final CompletableFuture<Void> cfCalc =
            this.tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
                .calcular(
                    algoritmo,
                    runTarea.getTarea(), personas);
        AsyncUtils.exceptionally(cfCalc, cf);

      } catch (final Exception e) {
        AsyncUtils.cancel(cf);
        PorVentaSinDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo.LOG.error(
            "Trabajo[{}]Tarea[{}] :: PorVentaSinDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo :: KO :: Personas: {}",
            runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size(), e);
        this.tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
            EstadoTareaCalculoPersonaEnum.KO.getDto());
      }
      PorVentaSinDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo.LOG.info(
          "Trabajo[{}]Tarea[{}] :: Fin :: PorVentaSinDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo :: Personas: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
    }
    AsyncUtils.waitAllOfIsOk(cf, cf);

    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public String getSqlCalcular(final AlgoritmoDTO algoritmo) {
    return this.tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .getSqlCalcular(algoritmo);
  }

}
