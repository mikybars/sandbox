package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Validation;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.migrar.RunTareaMigrarAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaMigrarService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaMigrarServiceImpl implements RunTareaMigrarService {

  @Autowired
  private RunTareaMigrarAsyncService runTareaMigrarAsyncService;

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
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      final CompletableFuture<Void> cfMigracion = this.runTareaMigrarAsyncService
          .migrarListCalculoComision(runTarea);
      AsyncUtils.exceptionally(cfMigracion, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

}
