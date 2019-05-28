package com.inditex.rrhh.icmclcwb.model.app.run.tarea.consolidar.async.service;

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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service.RunTareaConsolidarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTareaConsolidarByAmbitoServiceImpl implements RunTareaConsolidarByAmbitoService {

    @Autowired
    private RunTareaConsolidarPeriodoAsyncService runTareaConsolidarPeriodoAsyncService;
    
    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;
    
    @Autowired
    private TareaService tareaService;
    
    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            tareaCalculoPersonaService.updateWithEstado(runTarea, EstadoTareaCalculoPersonaEnum.PENDIENTE.getDto(), EstadoTareaCalculoPersonaEnum.OK.getDto());
                 
            CompletableFuture<Void> cfPeriodo = runTareaConsolidarPeriodoAsyncService.mergePeriodoPersona(runTarea);
            AsyncUtils.exceptionally(cfPeriodo, cf);

            CompletableFuture<Void> cfPeriodoCalculoPersona = runTareaConsolidarPeriodoAsyncService
                    .mergePeriodoCalculoPersona(runTarea);
            AsyncUtils.exceptionally(cfPeriodoCalculoPersona, cf);

            CompletableFuture<Void> cfPeriodoLocalizacion = runTareaConsolidarPeriodoAsyncService
                    .mergePeriodoLocalizacion(runTarea);
            AsyncUtils.exceptionally(cfPeriodoLocalizacion, cf);

            CompletableFuture<Void> cfPeriodoLocalizacionPersona = runTareaConsolidarPeriodoAsyncService
                    .mergePeriodoLocalizacionPersona(runTarea);
            AsyncUtils.exceptionally(cfPeriodoLocalizacionPersona, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            tareaService.updateEstadoFinal(runTarea.getTarea());
            
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
