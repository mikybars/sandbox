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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeV1RepositoryCustom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("porVentaSinDevolucionPorcentajeV1")
public class PorVentaSinDevolucionPorcentajeV1RunAlgoritmo implements RunAlgoritmo {

  private static final Logger LOG = LoggerFactory.getLogger(PorVentaSinDevolucionPorcentajeV1RunAlgoritmo.class);

  @Autowired
  @Qualifier("runAlgoritmoProperties")
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @Autowired
  private TareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeV1RepositoryCustom tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeV1RepositoryCustom;

  @Autowired
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Override
  public CompletableFuture<Void> execute(final RunTareaDto runTarea, final AlgoritmoDTO algoritmo) {
    PorVentaSinDevolucionPorcentajeV1RunAlgoritmo.LOG.info(
        "Trabajo[{}]Tarea[{}] :: Inicio :: PorVentaSinDevolucionPorcentajeV1RunAlgoritmo :: Ids",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId());
    final List<IdPersonaLocalDto> ids = this.tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeV1RepositoryCustom
        .ids(algoritmo, runTarea.getTarea());
    PorVentaSinDevolucionPorcentajeV1RunAlgoritmo.LOG.info(
        "Trabajo[{}]Tarea[{}] :: Fin :: PorVentaSinDevolucionPorcentajeV1RunAlgoritmo :: Ids: {}",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), ids);

    final List<CompletableFuture<?>> cf = new ArrayList<>();

    for (final List<IdPersonaLocalDto> personas : StreamUtils.partition(
        ids,
        this.runAlgoritmoProperties.getCalculo().getBatchSize())) {
      AsyncUtils.checkAsyncAvaliable(cf, this.runAlgoritmoProperties.getCalculo().getThreadSize());

      PorVentaSinDevolucionPorcentajeV1RunAlgoritmo.LOG.info(
          "Trabajo[{}]Tarea[{}] :: Inicio :: PorVentaSinDevolucionPorcentajeV1RunAlgoritmo :: Personas: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
      try {
        final CompletableFuture<Void> cfCalc = this.tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeV1RepositoryCustom
            .calcular(
                algoritmo,
                runTarea.getTarea(), personas);
        AsyncUtils.exceptionally(cfCalc, cf);

      } catch (final Exception e) {
        AsyncUtils.cancel(cf);
        PorVentaSinDevolucionPorcentajeV1RunAlgoritmo.LOG.error(
            "Trabajo[{}]Tarea[{}] :: PorVentaSinDevolucionPorcentajeV1RunAlgoritmo :: KO :: Personas: {}",
            runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size(), e);
        this.tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
            EstadoTareaCalculoPersonaEnum.KO.getDto());
      }
      PorVentaSinDevolucionPorcentajeV1RunAlgoritmo.LOG.info(
          "Trabajo[{}]Tarea[{}] :: Fin :: PorVentaSinDevolucionPorcentajeV1RunAlgoritmo :: Personas: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
    }
    AsyncUtils.waitAllOfIsOk(cf, cf);

    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public String getSqlCalcular(final AlgoritmoDTO algoritmo) {
    return this.tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeV1RepositoryCustom.getSqlCalcular(algoritmo);
  }

}
