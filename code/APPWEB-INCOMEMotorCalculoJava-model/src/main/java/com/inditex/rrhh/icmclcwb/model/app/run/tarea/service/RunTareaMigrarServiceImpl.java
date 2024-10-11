package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Validation;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaMigrarService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaMigrarServiceImpl implements RunTareaMigrarService {

  @Auditoria
  @Validation(fase = 10)
  @TimerFunctionalMetric(metricName = "RunTareaMigrarService.run.timer",
      metricGroupName = "RunTareaMigrarServiceGroup",
      metricDescription = "RunTareaMigrarService.run.timer")
  @CounterFunctionalMetric(metricName = "RunTareaMigrarService.run.counter",
      metricGroupName = "RunTareaMigrarServiceGroup",
      metricDescription = "RunTareaMigrarService.run.counter")
  @Override
  public void run(@NotNull @Valid final RunTareaDto runTarea) {
    final TrabajoDTO trabajo = runTarea.getTrabajo();
  }

}
