package com.inditex.rrhh.icmclcwb.model.app.run.tarea.consolidar.async.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.async.service.RunTareaConsolidarPeriodoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service.RunTareaConsolidarByAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaConsolidarByAmbitoPersonaServiceImpl implements RunTareaConsolidarByAmbitoPersonaService {

  private final RunTareaConsolidarPeriodoAsyncService runTareaConsolidarPeriodoAsyncService;

  @Auditoria
  @TimerFunctionalMetric(metricName = "RunTareaConsolidarByAmbitoPersonaService.run.timer",
      metricGroupName = "RunTareaConsolidarByAmbitoPersonaServiceGroup",
      metricDescription = "RunTareaConsolidarByAmbitoPersonaService.run.timer")
  @CounterFunctionalMetric(metricName = "RunTareaConsolidarByAmbitoPersonaService.run.counter",
      metricGroupName = "RunTareaConsolidarByAmbitoPersonaServiceGroup",
      metricDescription = "RunTareaConsolidarByAmbitoPersonaService.run.counter")
  @Override
  public void run(@NonNull @Valid final RunTareaDto runTarea) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      final CompletableFuture<Void> cfPeriodo = this.runTareaConsolidarPeriodoAsyncService
          .mergePeriodoPersona(runTarea);
      AsyncUtils.exceptionally(cfPeriodo, cf);

      final CompletableFuture<Void> cfPeriodoCalculoPersona = this.runTareaConsolidarPeriodoAsyncService
          .mergePeriodoCalculoPersona(runTarea);
      AsyncUtils.exceptionally(cfPeriodoCalculoPersona, cf);

      final CompletableFuture<Void> cfPeriodoLocalizacion = this.runTareaConsolidarPeriodoAsyncService
          .mergePeriodoLocalizacion(runTarea);
      AsyncUtils.exceptionally(cfPeriodoLocalizacion, cf);

      final CompletableFuture<Void> cfPeriodoLocalizacionPersona = this.runTareaConsolidarPeriodoAsyncService
          .mergePeriodoLocalizacionPersona(runTarea);
      AsyncUtils.exceptionally(cfPeriodoLocalizacionPersona, cf);

      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cf);
      /*-------------------------------------------------------------*/
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

}
