package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaSimularService;
import com.inditex.rrhh.icmclcwb.api.app.simulacion.service.SimulacionService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaSimularServiceImpl implements RunTareaSimularService {

  @Autowired
  private SimulacionService simulacionService;

  @Auditoria
  @TimerFunctionalMetric(metricName = "RunTareaSimularService.run.timer",
      metricGroupName = "RunTareaSimularServiceGroup",
      metricDescription = "RunTareaSimularService.run.timer")
  @CounterFunctionalMetric(metricName = "RunTareaSimularService.run.counter",
      metricGroupName = "RunTareaSimularServiceGroup",
      metricDescription = "RunTareaSimularService.run.counter")
  @Override
  public void run(@NotNull @Valid final RunTareaDto runTarea) {
    final TrabajoDTO trabajo = runTarea.getTrabajo();
    if (trabajo.getIdSimulacion() != null) {
      this.simulacionService.mergeEstructurasEmpleadoSimulacion(runTarea.getTarea());
      this.simulacionService.mergePresenciasEmpleadoSimulacion(runTarea.getTarea());
    }

  }
}
