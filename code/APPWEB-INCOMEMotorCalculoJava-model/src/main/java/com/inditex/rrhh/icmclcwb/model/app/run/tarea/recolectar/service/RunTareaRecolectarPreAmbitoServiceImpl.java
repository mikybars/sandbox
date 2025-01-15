package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarPreAmbitoService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaRecolectarPreAmbitoServiceImpl implements RunTareaRecolectarPreAmbitoService {

  private final RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;

  @Auditoria
  @TimerFunctionalMetric(metricName = "RunTareaRecolectarPreAmbitoService.run.timer",
      metricGroupName = "RunTareaRecolectarPreAmbitoServiceGroup",
      metricDescription = "RunTareaRecolectarPreAmbitoService.run.timer")
  @CounterFunctionalMetric(metricName = "RunTareaRecolectarPreAmbitoService.run.counter",
      metricGroupName = "RunTareaRecolectarPreAmbitoServiceGroup",
      metricDescription = "RunTareaRecolectarPreAmbitoService.run.counter")
  @Override
  public void run(@NonNull @Valid final RunTareaDto runTarea) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {

      final CompletableFuture<Void> cfPersonaByRunTarea = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .fechaAmbitoAndEmpresaByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfPersonaByRunTarea, cf);

      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cf);
      /*-------------------------------------------------------------*/

    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

}
