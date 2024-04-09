package com.inditex.rrhh.icmclcwb.model.app.calcular.directoventapresencia.v1;

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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeDesplazamientoV1RepositoryCustom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("directoVentaPresenciaPorcentajeDesplazamientoV1")
public class DirectoVentaPresenciaPorcentajeDesplazamientoV1RunAlgoritmo implements RunAlgoritmo {

  private static final Logger LOG = LoggerFactory.getLogger(DirectoVentaPresenciaPorcentajeDesplazamientoV1RunAlgoritmo.class);

  @Autowired
  @Qualifier("runAlgoritmoProperties")
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @Autowired
  private TareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeDesplazamientoV1RepositoryCustom tareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeDesplazamientoV1RepositoryCustom;

  @Autowired
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Override
  public CompletableFuture<Void> execute(final RunTareaDto runTarea, final AlgoritmoDTO algoritmo) {
    DirectoVentaPresenciaPorcentajeDesplazamientoV1RunAlgoritmo.LOG.info(
        "Trabajo[{}]Tarea[{}] :: Inicio :: DirectoVentaPresenciaPorcentajeDesplazamientoV1RunAlgoritmo :: Ids",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId());
    final List<IdPersonaLocalDto> ids = this.tareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeDesplazamientoV1RepositoryCustom
        .ids(algoritmo, runTarea.getTarea());
    DirectoVentaPresenciaPorcentajeDesplazamientoV1RunAlgoritmo.LOG.info(
        "Trabajo[{}]Tarea[{}] :: Fin :: DirectoVentaPresenciaPorcentajeDesplazamientoV1RunAlgoritmo :: Ids: {}",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), ids);

    final List<CompletableFuture<?>> cf = new ArrayList<>();

    for (final List<IdPersonaLocalDto> personas : StreamUtils.partition(
        ids,
        this.runAlgoritmoProperties.getCalculo().getBatchSize())) {
      AsyncUtils.checkAsyncAvaliable(cf, this.runAlgoritmoProperties.getCalculo().getThreadSize());

      DirectoVentaPresenciaPorcentajeDesplazamientoV1RunAlgoritmo.LOG.info(
          "Trabajo[{}]Tarea[{}] :: Inicio :: DirectoVentaPresenciaPorcentajeDesplazamientoV1RunAlgoritmo :: Personas: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
      try {
        final CompletableFuture<Void> cfCalc = this.tareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeDesplazamientoV1RepositoryCustom
            .calcular(
                algoritmo,
                runTarea.getTarea(), personas);
        AsyncUtils.exceptionally(cfCalc, cf);
      } catch (final Exception e) {
        AsyncUtils.cancel(cf);
        DirectoVentaPresenciaPorcentajeDesplazamientoV1RunAlgoritmo.LOG.error(
            "Trabajo[{}]Tarea[{}] :: DirectoVentaPresenciaPorcentajeDesplazamientoV1RunAlgoritmo :: KO :: Personas: {}",
            runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size(), e);
        this.tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
            EstadoTareaCalculoPersonaEnum.KO.getDto());
      }
      DirectoVentaPresenciaPorcentajeDesplazamientoV1RunAlgoritmo.LOG.info(
          "Trabajo[{}]Tarea[{}] :: Fin :: DirectoVentaPresenciaPorcentajeDesplazamientoV1RunAlgoritmo :: Personas: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
    }
    AsyncUtils.waitAllOfIsOk(cf, cf);

    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public String getSqlCalcular(final AlgoritmoDTO algoritmo) {
    return this.tareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeDesplazamientoV1RepositoryCustom
        .getSqlCalcular(algoritmo);
  }

}
