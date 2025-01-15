package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaCalculoPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaRecolectarByAmbitoServiceImpl implements RunTareaRecolectarByAmbitoService {

  @Autowired
  private TareaCalculoPersonaAsyncService tareaCalculoPersonaAsyncService;

  @Auditoria
  @TimerFunctionalMetric(metricName = "RunTareaRecolectarByAmbitoService.run.timer",
      metricGroupName = "RunTareaRecolectarByAmbitoServiceGroup",
      metricDescription = "RunTareaRecolectarByAmbitoService.run.timer")
  @CounterFunctionalMetric(metricName = "RunTareaRecolectarByAmbitoService.run.counter",
      metricGroupName = "RunTareaRecolectarByAmbitoServiceGroup",
      metricDescription = "RunTareaRecolectarByAmbitoService.run.counter")
  @Override
  public void run(@NotNull @Valid final RunTareaDto runTarea) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      final CompletableFuture<Void> cfMergePersonaCalculo = this.tareaCalculoPersonaAsyncService
          .mergePersonaCalculoByAmbito(runTarea);
      AsyncUtils.exceptionally(cfMergePersonaCalculo, cf);
      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cf);
      /*-------------------------------------------------------------*/
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

}
