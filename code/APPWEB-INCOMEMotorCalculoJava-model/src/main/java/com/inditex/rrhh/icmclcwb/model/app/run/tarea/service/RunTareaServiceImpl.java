package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.List;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.ValidationNoReintentoException;
import com.inditex.rrhh.icmclcwb.api.app.exception.ValidationReintentoException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.limpiar.consolidar.service.RunTareaLimpiarConsolidarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaAjustarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaConsolidarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaMigrarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaNormalizarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaProcesarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarValidarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRegularizarChallengeService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRegularizarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaSimularService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaMigrarComisionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaMigrarService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaServiceImpl implements RunTareaService {

  private static final Logger logger = LoggerFactory.getLogger(RunTareaServiceImpl.class);

  private final TareaService tareaService;

  private final TareaCalculoPersonaService tareaCalculoPersonaService;

  private final RunTareaRecolectarService runTareaRecolectarService;

  private final RunTareaProcesarService runTareaProcesarService;

  private final RunTareaCalcularService runTareaCalcularService;

  private final RunTareaConsolidarService runTareaConsolidarService;

  private final RunTareaRecolectarValidarService runTareaRecolectarValidarService;

  private final RunTareaRegularizarService runTareaRegularizarService;

  private final RunTareaRegularizarChallengeService runTareaRegularizarChallengeService;

  private final RunTareaLimpiarConsolidarByAmbitoService runTareaLimpiarConsolidarByAmbitoService;

  private final RunTareaAjustarService runTareaAjustarService;

  private final RunTareaNormalizarService runTareaNormalizarService;

  private final TareaFaseService tareaFaseService;

  private final RunTareaSimularService runTareaSimularService;

  private final RunTareaMigrarService runTareaMigrarService;

  private final TareaFaseAccionService tareaFaseAccionService;

  private final TareaMigrarService tareaMigrarService;

  @Auditoria
  @TimerFunctionalMetric(metricName = "RunTareaService.run.timer", metricGroupName = "RunTareaServiceGroup",
      metricDescription = "RunTareaService.run.timer")
  @CounterFunctionalMetric(metricName = "RunTareaService.run.counter", metricGroupName = "RunTareaServiceGroup",
      metricDescription = "RunTareaService.run.counter")
  @Override
  public void run(@NotNull @Valid final RunTareaDto runTarea) {
    try {
      if (runTarea.getTarea().getFechaHoraInicioTarea() != null) {
        this.tareaService.updateEstado(runTarea.getTarea(), EstadoTareaEnum.EN_CURSO.getDto());
      } else {
        this.tareaService.updateFechaInicioAndEstado(runTarea.getTarea(), EstadoTareaEnum.EN_CURSO.getDto());
      }
      this.tareaFaseService.create(runTarea);
      this.tareaFaseAccionService.create(runTarea);
      this.runTareaSimularService.run(runTarea);
      this.runTareaRecolectarService.run(runTarea);
      this.runTareaRecolectarValidarService.run(runTarea);
      this.runTareaProcesarService.run(runTarea);
      this.runTareaCalcularService.run(runTarea);
      this.runTareaRegularizarChallengeService.run(runTarea);
      this.runTareaRegularizarService.run(runTarea);
      this.runTareaAjustarService.run(runTarea);
      this.runTareaNormalizarService.run(runTarea);
      this.tareaFaseService.updateActivo(runTarea);
      this.tareaCalculoPersonaService.updateWithEstado(runTarea, EstadoTareaCalculoPersonaEnum.PENDIENTE.getDto(),
          EstadoTareaCalculoPersonaEnum.OK.getDto());
      if (TipoAmbitoEnum.SOCIEDAD.getId().equals(runTarea.getTrabajo().getTipoAmbito().getId())
          || TipoAmbitoEnum.ORIGEN.getId().equals(runTarea.getTrabajo().getTipoAmbito().getId())
          || TipoAmbitoEnum.EMPRESA.getId().equals(runTarea.getTrabajo().getTipoAmbito().getId())) {
        this.runTareaLimpiarConsolidarByAmbitoService.run(runTarea);
      }

      final List<TareaMigrarComisionDto> deleteMigracion = this.tareaMigrarService.deleteCalculoComisionByTareaActual(runTarea,
          runTarea.getTarea().getAmbito().get(0));

      this.runTareaConsolidarService.run(runTarea);
      this.tareaService.updateEstadoFinal(runTarea.getTarea());
      this.tareaService.updateFechaFin(runTarea.getTarea());
      this.runTareaMigrarService.run(runTarea, deleteMigracion);
    } catch (final ValidationNoReintentoException | ValidationReintentoException e) {
      if (e instanceof ValidationNoReintentoException) {
        this.tareaCalculoPersonaService.updateWithEstado(runTarea, EstadoTareaCalculoPersonaEnum.PENDIENTE.getDto(),
            EstadoTareaCalculoPersonaEnum.KO.getDto());
        this.runTareaConsolidarService.run(runTarea);
        this.tareaService.updateEstado(runTarea.getTarea(), EstadoTareaEnum.ERROR_VALIDANDO.getDto());
        this.tareaService.updateFechaFin(runTarea.getTarea());
      }
    } catch (final Exception e) {
      this.tareaCalculoPersonaService.updateWithEstado(runTarea, EstadoTareaCalculoPersonaEnum.PENDIENTE.getDto(),
          EstadoTareaCalculoPersonaEnum.KO.getDto());
      this.runTareaConsolidarService.run(runTarea);
      this.tareaService.updateEstado(runTarea.getTarea(), EstadoTareaEnum.ERROR.getDto());
      this.tareaService.updateFechaFin(runTarea.getTarea());
      this.logError(runTarea.getTarea().getId(), e);
      throw e;
    }
  }

  private void logError(Long tareaId, Exception e) {
    logger.error("Tarea processing failed for ID: {}", tareaId, e);
  }
}
