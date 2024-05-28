package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Validation;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.normalizar.async.service.RunTareaNormalizarAjusteComisionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaNormalizarService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaNormalizarServiceImpl implements RunTareaNormalizarService {

  @Autowired
  private TareaFaseService tareaFaseService;

  @Autowired
  private RunTareaNormalizarAjusteComisionAsyncService runTareaNormalizarAjusteComisionAsyncService;

  @Auditoria
  @Validation(fase = 8)
  @TimerFunctionalMetric(metricName = "RunTareaNormalizarService.run.timer",
      metricGroupName = "RunTareaNormalizarServiceGroup",
      metricDescription = "RunTareaNormalizarService.run.timer")
  @CounterFunctionalMetric(metricName = "RunTareaNormalizarService.run.counter",
      metricGroupName = "RunTareaNormalizarServiceGroup",
      metricDescription = "RunTareaNormalizarService.run.counter")
  @Override
  public void run(@NotNull @Valid final RunTareaDto runTarea) {

    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfWait = new ArrayList<>();
    final TareaFaseDto tareaFase = this.tareaFaseService
        .findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
            FaseEnum.NORMALIZAR.getId());
    try {

      this.tareaFaseService.updateFechaInicio(tareaFase);

      final CompletableFuture<Void> cfNormalizarAjusteComision = this.runTareaNormalizarAjusteComisionAsyncService
          .normalizarAjusteComision(runTarea.getTarea());
      AsyncUtils.exceptionally(cfNormalizarAjusteComision, cf, cfWait);

      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cfWait);
      /*-------------------------------------------------------------*/

      this.tareaFaseService.updateFechaFinAndEstado(tareaFase, EstadoTareaFaseEnum.OK.getDto());

    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      this.tareaFaseService.updateFechaFinAndEstado(tareaFase, EstadoTareaFaseEnum.KO.getDto());
      throw e;
    }

  }

}
