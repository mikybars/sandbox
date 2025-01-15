package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Validation;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.regularizar.async.service.RunTareaRegularizarCalculoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRegularizarService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaRegularizarServiceImpl implements RunTareaRegularizarService {

  private final RunTareaRegularizarCalculoAsyncService runTareaRegularizarAsyncService;

  private final TareaFaseService tareaFaseService;

  @Auditoria
  @Validation(fase = 6)
  @TimerFunctionalMetric(metricName = "RunTareaRegularizarService.run.timer",
      metricGroupName = "RunTareaRegularizarServiceGroup",
      metricDescription = "RunTareaRegularizarService.run.timer")
  @CounterFunctionalMetric(metricName = "RunTareaRegularizarService.run.counter",
      metricGroupName = "RunTareaRegularizarServiceGroup",
      metricDescription = "RunTareaRegularizarService.run.counter")
  @Override
  public void run(@NonNull @Valid final RunTareaDto runTarea) {

    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      this.tareaFaseService.updateFechaInicio(
          this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
              FaseEnum.REGULARIZAR.getId()));

      final CompletableFuture<Void> cfPostProcesarCalculo = this.runTareaRegularizarAsyncService
          .regularizarCalculoMejorOpcion(runTarea);
      AsyncUtils.exceptionally(cfPostProcesarCalculo, cf);

      final CompletableFuture<Void> cfPostProcesarCalculoSinFechas = this.runTareaRegularizarAsyncService
          .regularizarMejorOpcionSinFechas(runTarea);
      AsyncUtils.exceptionally(cfPostProcesarCalculoSinFechas, cf);

      final CompletableFuture<Void> cfPostProcesarCalculoSinFechasTodoPeriodo = this.runTareaRegularizarAsyncService
          .regularizarMejorOpcionSinFechasTodoPeriodo(runTarea);
      AsyncUtils.exceptionally(cfPostProcesarCalculoSinFechasTodoPeriodo, cf);

      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cf);
      /*-------------------------------------------------------------*/

      this.tareaFaseService.updateFechaFinAndEstado(
          this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
              FaseEnum.REGULARIZAR.getId()),
          EstadoTareaFaseEnum.OK.getDto());
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      this.tareaFaseService.updateFechaFinAndEstado(
          this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
              FaseEnum.REGULARIZAR.getId()),
          EstadoTareaFaseEnum.KO.getDto());
      throw e;
    }
  }

}
