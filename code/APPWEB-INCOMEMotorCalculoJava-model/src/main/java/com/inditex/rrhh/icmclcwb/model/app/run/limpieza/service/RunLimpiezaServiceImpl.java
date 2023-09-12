package com.inditex.rrhh.icmclcwb.model.app.run.limpieza.service;

import com.inditex.aqsw.framework.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.aqsw.framework.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.limpieza.service.LimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.dto.RunLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.service.RunLimpiezaService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunLimpiezaServiceImpl implements RunLimpiezaService {

  @Autowired
  private LimpiezaService limpiezaService;

  @Auditoria
  @TimerFunctionalMetric(metricName = "RunLimpiezaService.run.timer", metricGroupName = "RunLimpiezaServiceGroup",
      metricDescription = "RunLimpiezaService.run.timer")
  @CounterFunctionalMetric(metricName = "RunLimpiezaService.run.counter", metricGroupName = "RunLimpiezaServiceGroup",
      metricDescription = "RunLimpiezaService.run.counter")
  @Override
  public void run(@NotNull @Valid final RunLimpiezaDto runLimpieza) {
    this.limpiezaService.runTarea(runLimpieza);
  }

}
