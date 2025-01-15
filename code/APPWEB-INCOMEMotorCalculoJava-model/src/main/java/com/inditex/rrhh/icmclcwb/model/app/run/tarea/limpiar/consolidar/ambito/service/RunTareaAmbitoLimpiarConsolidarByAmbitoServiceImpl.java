package com.inditex.rrhh.icmclcwb.model.app.run.tarea.limpiar.consolidar.ambito.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.async.service.RunTareaConsolidarPeriodoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.limpiar.consolidar.ambito.service.RunTareaAmbitoLimpiarConsolidarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaAmbitoLimpiarConsolidarByAmbitoServiceImpl
    implements RunTareaAmbitoLimpiarConsolidarByAmbitoService {

  private final RunTareaConsolidarPeriodoAsyncService runTareaConsolidarPeriodoAsyncService;

  @Auditoria
  @TimerFunctionalMetric(metricName = "RunTareaAmbitoLimpiarConsolidarByAmbitoService.run.timer",
      metricGroupName = "RunTareaAmbitoLimpiarConsolidarByAmbitoServiceGroup",
      metricDescription = "RunTareaAmbitoLimpiarConsolidarByAmbitoService.run.timer")
  @CounterFunctionalMetric(metricName = "RunTareaAmbitoLimpiarConsolidarByAmbitoService.run.counter",
      metricGroupName = "RunTareaAmbitoLimpiarConsolidarByAmbitoServiceGroup",
      metricDescription = "RunTareaAmbitoLimpiarConsolidarByAmbitoService.run.counter")
  @Override
  public void run(@NonNull @Valid final RunTareaDto runTarea, @NonNull @Valid final TareaAmbitoDto tareaAmbitoDto) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      final CompletableFuture<Void> cfPeriodo = this.runTareaConsolidarPeriodoAsyncService
          .limpiezaPeriodoPersona(runTarea, tareaAmbitoDto);
      AsyncUtils.exceptionally(cfPeriodo, cf);

      final CompletableFuture<Void> cfPeriodoCalculoPersona = this.runTareaConsolidarPeriodoAsyncService
          .limpiezaPeriodoCalculoPersona(runTarea, tareaAmbitoDto);
      AsyncUtils.exceptionally(cfPeriodoCalculoPersona, cf);

      final CompletableFuture<Void> cfPeriodoLocalizacion = this.runTareaConsolidarPeriodoAsyncService
          .limpiezaPeriodoLocalizacion(runTarea, tareaAmbitoDto);
      AsyncUtils.exceptionally(cfPeriodoLocalizacion, cf);

      final CompletableFuture<Void> cfPeriodoLocalizacionPersona = this.runTareaConsolidarPeriodoAsyncService
          .limpiezaPeriodoLocalizacionPersona(runTarea, tareaAmbitoDto);
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
