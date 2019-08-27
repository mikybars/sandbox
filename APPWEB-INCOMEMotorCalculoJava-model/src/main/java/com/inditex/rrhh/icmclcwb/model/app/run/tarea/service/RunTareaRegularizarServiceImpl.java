package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.regularizar.async.service.RunTareaRegularizarCalculoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRegularizarService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTareaRegularizarServiceImpl implements RunTareaRegularizarService {

    @Autowired
    private RunTareaRegularizarCalculoAsyncService runTareaRegularizarAsyncService;

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            CompletableFuture<Void> cfPostProcesarCalculo = runTareaRegularizarAsyncService.regularizarCalculoMejorOpcion(runTarea);
            AsyncUtils.exceptionally(cfPostProcesarCalculo, cf);
            
            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/            
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }
}
