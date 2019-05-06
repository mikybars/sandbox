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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.async.service.RunTareaConsolidarPeriodoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaConsolidarService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTareaConsolidarServiceImpl implements RunTareaConsolidarService {

    @Autowired
    private TareaService tareaService;
    
    @Autowired
    private RunTareaConsolidarPeriodoAsyncService runTareaConsolidarPeriodoAsyncService;

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public RunTareaDto run(@NotNull @Valid final RunTareaDto runTarea) {
        TareaDto tarea = runTarea.getTarea();
        List<CompletableFuture<?>> cf = new ArrayList<>();

        CompletableFuture<Void> cfPeriodo = runTareaConsolidarPeriodoAsyncService.mergePeriodoPersona(runTarea);
        AsyncUtils.exceptionally(cfPeriodo, cf);
        
        CompletableFuture<Void> cfPeriodoCalculoPersona = runTareaConsolidarPeriodoAsyncService.mergePeriodoCalculoPersona(runTarea);
        AsyncUtils.exceptionally(cfPeriodoCalculoPersona, cf);
        
        CompletableFuture<Void> cfPeriodoLocalizacion = runTareaConsolidarPeriodoAsyncService.mergePeriodoLocalizacion(runTarea);
        AsyncUtils.exceptionally(cfPeriodoLocalizacion, cf);
        
        CompletableFuture<Void> cfPeriodoLocalizacionPersona = runTareaConsolidarPeriodoAsyncService.mergePeriodoLocalizacionPersona(runTarea);
        AsyncUtils.exceptionally(cfPeriodoLocalizacionPersona, cf);
        
        /*-------------------------------------------------------------*/
        AsyncUtils.waitAllOfIsOk(cf, cf);
        /*-------------------------------------------------------------*/
        tareaService.modifyEstadoTarea(tarea, EstadoTareaEnum.FINALIZADO_SIN_ERRORES.getDto());
        return runTarea;
    }

}
