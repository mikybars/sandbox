package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Validation;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarCondicionesBaseService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarCondicionesService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarPreAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarService;
import com.inditex.rrhh.icmclcwb.api.app.simulacion.dto.SimulacionDto;
import com.inditex.rrhh.icmclcwb.api.app.simulacion.service.SimulacionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaRecolectarServiceImpl implements RunTareaRecolectarService {

  private final RunTareaRecolectarPreAmbitoService runTareaRecolectarPreAmbitoService;

  private final RunTareaRecolectarAmbitoService runTareaRecolectarAmbitoService;

  private final RunTareaRecolectarCondicionesService runTareaRecolectarCondicionesService;

  private final RunTareaRecolectarCondicionesBaseService runTareaRecolectarCondicionesBaseService;

  private final TareaFaseService tareaFaseService;

  private final SimulacionService simulacionService;

  @Auditoria
  @Validation(fase = 1)
  @TimerFunctionalMetric(metricName = "RunTareaRecolectarService.run.timer",
      metricGroupName = "RunTareaRecolectarServiceGroup",
      metricDescription = "RunTareaRecolectarService.run.timer")
  @CounterFunctionalMetric(metricName = "RunTareaRecolectarService.run.counter",
      metricGroupName = "RunTareaRecolectarServiceGroup",
      metricDescription = "RunTareaRecolectarService.run.counter")
  @Override
  public void run(@NotNull @Valid final RunTareaDto runTarea) {
    this.tareaFaseService.updateFechaInicio(
        this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
            FaseEnum.RECOLECTAR.getId()));
    this.runTareaRecolectarPreAmbitoService.run(runTarea);
    this.runTareaRecolectarAmbitoService.run(runTarea);
    this.runTareaRecolectarCondicionesBaseService.run(runTarea);
    this.runTareaRecolectarCondicionesService.run(runTarea);
    if (runTarea.getTrabajo().getIdSimulacion() != null) {
      final SimulacionDto simulacion = this.simulacionService.findbyId(runTarea.getTrabajo().getIdSimulacion());
      this.simulacionService.updateBandaExcepcionada(runTarea.getTarea(), simulacion);
    }
    this.tareaFaseService.updateFechaFinAndEstado(
        this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
            FaseEnum.RECOLECTAR.getId()),
        EstadoTareaFaseEnum.OK.getDto());

  }

}
