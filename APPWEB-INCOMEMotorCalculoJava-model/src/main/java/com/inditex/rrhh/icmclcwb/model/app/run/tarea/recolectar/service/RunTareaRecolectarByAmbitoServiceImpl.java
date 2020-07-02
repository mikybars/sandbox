package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.CounterFunctionalMetric;
import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaCalculoPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

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
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            CompletableFuture<Void> cfMergePersonaCalculo = tareaCalculoPersonaAsyncService
                .mergePersonaCalculoByAmbito(runTarea);
            AsyncUtils.exceptionally(cfMergePersonaCalculo, cf);
            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
