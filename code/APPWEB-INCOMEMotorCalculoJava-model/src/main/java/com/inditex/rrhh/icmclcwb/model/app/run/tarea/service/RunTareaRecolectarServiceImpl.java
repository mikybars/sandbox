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
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaRecolectarServiceImpl implements RunTareaRecolectarService {

  @Autowired
  private RunTareaRecolectarPreAmbitoService runTareaRecolectarPreAmbitoService;

  @Autowired
  private RunTareaRecolectarAmbitoService runTareaRecolectarAmbitoService;

  @Autowired
  private RunTareaRecolectarCondicionesService runTareaRecolectarCondicionesService;

  @Autowired
  private RunTareaRecolectarCondicionesBaseService runTareaRecolectarCondicionesBaseService;

  @Autowired
  private TareaFaseService tareaFaseService;

  @Auditoria
  @Validation(fase = 1)
  @TimerFunctionalMetric(metricName = "RunTareaRecolectarService.run.timer",
      metricGroupName = "RunTareaRecolectarServiceGroup",
      metricDescription = "RunTareaRecolectarService.run.timer")
  @CounterFunctionalMetric(metricName = "RunTareaRecolectarService.run.counter",
      metricGroupName = "RunTareaRecolectarServiceGroup",
      metricDescription = "RunTareaRecolectarService.run.counter")
  @Override
  public void run(@NonNull @Valid final RunTareaDto runTarea) {
    this.tareaFaseService.updateFechaInicio(
        this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
            FaseEnum.RECOLECTAR.getId()));
    this.runTareaRecolectarPreAmbitoService.run(runTarea);
    this.runTareaRecolectarAmbitoService.run(runTarea);
    this.runTareaRecolectarCondicionesBaseService.run(runTarea);
    this.runTareaRecolectarCondicionesService.run(runTarea);
    this.tareaFaseService.updateFechaFinAndEstado(
        this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
            FaseEnum.RECOLECTAR.getId()),
        EstadoTareaFaseEnum.OK.getDto());

  }

}
