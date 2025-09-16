package com.inditex.rrhh.icmclcwb.model.app.calcular.challengedirectoventa.v1;

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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoBaseV1RepositoryCustom;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("challengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1")
@RequiredArgsConstructor
public class ChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmo implements RunAlgoritmo {

  private static final Logger LOG =
      LoggerFactory.getLogger(ChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmo.class);

  private final TareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoBaseV1RepositoryCustom tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoBaseV1RepositoryCustom;

  private final RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  private final TareaCalculoPersonaService tareaCalculoPersonaService;

  @Override
  public CompletableFuture<Void> execute(RunTareaDto runTarea, AlgoritmoDTO algoritmo) {
    ChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmo.LOG.info(
        "Trabajo[{}]Tarea[{}] :: Inicio :: ChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmo :: Ids",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId());
    final List<IdPersonaLocalDto> ids = this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoBaseV1RepositoryCustom
        .ids(algoritmo, runTarea.getTarea());
    ChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmo.LOG.info(
        "Trabajo[{}]Tarea[{}] :: Fin :: ChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmo :: Ids: {}",
        runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), ids);

    final List<CompletableFuture<?>> cf = new ArrayList<>();

    for (final List<IdPersonaLocalDto> personas : StreamUtils.partition(
        ids,
        this.runAlgoritmoProperties.getCalculo().getBatchSize())) {
      AsyncUtils.checkAsyncAvaliable(cf, this.runAlgoritmoProperties.getCalculo().getThreadSize());

      ChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmo.LOG.info(
          "Trabajo[{}]Tarea[{}] :: Inicio :: ChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmo :: Personas: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
      try {
        final CompletableFuture<Void> cfCalc =
            this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoBaseV1RepositoryCustom
                .calcular(algoritmo, runTarea.getTarea(), personas);
        AsyncUtils.exceptionally(cfCalc, cf);
      } catch (final Exception e) {
        ChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmo.LOG.error(
            "Trabajo[{}]Tarea[{}] :: ChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmo :: KO :: Personas: {}",
            runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size(), e);
        this.tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
            EstadoTareaCalculoPersonaEnum.KO.getDto());
      }
      ChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmo.LOG.info(
          "Trabajo[{}]Tarea[{}] :: Fin :: ChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmo :: Personas: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
    }
    AsyncUtils.waitAllOfIsOk(cf, cf);

    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public String getSqlCalcular(final AlgoritmoDTO algoritmo) {
    return this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoBaseV1RepositoryCustom.getSqlCalcular(algoritmo);
  }

}
