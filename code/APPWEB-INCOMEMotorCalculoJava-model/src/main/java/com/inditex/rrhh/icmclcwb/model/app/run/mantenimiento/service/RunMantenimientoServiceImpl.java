package com.inditex.rrhh.icmclcwb.model.app.run.mantenimiento.service;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.limpieza.service.RunMantenimientoLimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.service.RunMantenimientoService;
import com.inditex.rrhh.icmclcwb.dto.RunMantenimientoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunMantenimientoServiceImpl implements RunMantenimientoService {

  @Autowired
  private RunMantenimientoLimpiezaService runMantenimientoLimpiezaService;

  @Auditoria
  @TimerFunctionalMetric(metricName = "RunMantenimientoService.run.timer",
      metricGroupName = "RunMantenimientoServiceGroup", metricDescription = "RunMantenimientoService.run.timer")
  @CounterFunctionalMetric(metricName = "RunMantenimientoService.run.counter",
      metricGroupName = "RunMantenimientoServiceGroup", metricDescription = "RunMantenimientoService.run.counter")
  @Override
  public RunMantenimientoDTO run() {
    final RunMantenimientoDTO mto = new RunMantenimientoDTO();
    mto.setRunMantenimientoLimpieza(this.runMantenimientoLimpiezaService.run());
    return mto;
  }

  @Auditoria
  @TimerFunctionalMetric(metricName = "RunMantenimientoService.runIdTarea.timer",
      metricGroupName = "RunMantenimientoServiceGroup",
      metricDescription = "RunMantenimientoService.runIdTarea.timer")
  @CounterFunctionalMetric(metricName = "RunMantenimientoService.runIdTarea.counter",
      metricGroupName = "RunMantenimientoServiceGroup",
      metricDescription = "RunMantenimientoService.runIdTarea.counter")
  @Override
  public RunMantenimientoDTO runIdTarea(@NotNull final Long id) {
    final RunMantenimientoDTO mto = new RunMantenimientoDTO();
    mto.setRunMantenimientoLimpieza(this.runMantenimientoLimpiezaService.runIdTarea(id));
    return mto;
  }

}
