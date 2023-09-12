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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDesplazamientoBaseV1RepositoryCustom;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("porVentaDevolucionPorcentajeDesplazamientoBaseV1")
public class PorVentaDevolucionPorcentajeDesplazamientoBaseV1RunAlgoritmo implements RunAlgoritmo {

  @Autowired
  private Logger log;

  @Autowired
  @Qualifier("runAlgoritmoProperties")
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @Autowired
  private TareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDesplazamientoBaseV1RepositoryCustom tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDesplazamientoBaseV1RepositoryCustom;

  @Autowired
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Override
  public CompletableFuture<Void> execute(final RunTareaDto runTarea, final AlgoritmoDTO algoritmo) {
    this.log.info(
        "Trabajo[{}]Tarea[{}] :: Inicio :: PorVentaDevolucionPorcentajeDesplazamientoBaseV1RunAlgoritmo :: Ids",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId());
    final List<IdPersonaLocalDto> ids = this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDesplazamientoBaseV1RepositoryCustom
        .ids(algoritmo, runTarea.getTarea());
    this.log.info(
        "Trabajo[{}]Tarea[{}] :: Fin :: PorVentaDevolucionPorcentajeDesplazamientoBaseV1RunAlgoritmo :: Ids: {}",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), ids);

    final List<CompletableFuture<?>> cf = new ArrayList<>();

    for (final List<IdPersonaLocalDto> personas : StreamUtils.partition(
        ids,
        this.runAlgoritmoProperties.getCalculo().getBatchSize())) {
      AsyncUtils.checkAsyncAvaliable(cf, this.runAlgoritmoProperties.getCalculo().getThreadSize());

      this.log.info(
          "Trabajo[{}]Tarea[{}] :: Inicio :: PorVentaDevolucionPorcentajeDesplazamientoBaseV1RunAlgoritmo :: Personas: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
      try {
        final CompletableFuture<Void> cfCalc = this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDesplazamientoBaseV1RepositoryCustom
            .calcular(algoritmo,
                runTarea.getTarea(), personas);
        AsyncUtils.exceptionally(cfCalc, cf);

      } catch (final Exception e) {
        AsyncUtils.cancel(cf);
        this.log.error(
            "Trabajo[{}]Tarea[{}] :: PorVentaDevolucionPorcentajeDesplazamientoBaseV1RunAlgoritmo :: KO :: Personas: {}",
            runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size(), e);
        this.tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
            EstadoTareaCalculoPersonaEnum.KO.getDto());
      }
      this.log.info(
          "Trabajo[{}]Tarea[{}] :: Fin :: PorVentaDevolucionPorcentajeDesplazamientoBaseV1RunAlgoritmo :: Personas: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
    }
    AsyncUtils.waitAllOfIsOk(cf, cf);

    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public String getSqlCalcular(final AlgoritmoDTO algoritmo) {
    return this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDesplazamientoBaseV1RepositoryCustom
        .getSqlCalcular(algoritmo);
  }

}
