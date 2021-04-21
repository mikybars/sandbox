package com.inditex.rrhh.icmclcwb.model.app.run.tarea.consolidar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.async.service.RunTareaConsolidarPeriodoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service.RunTareaConsolidarPeriodoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaConsolidarPeriodoAsyncServiceImpl implements RunTareaConsolidarPeriodoAsyncService {

    @Autowired
    private RunTareaConsolidarPeriodoService runTareaConsolidarPeriodoService;

    @Override
    public CompletableFuture<Void> mergePeriodoPersona(final RunTareaDto runTarea) {
        runTareaConsolidarPeriodoService.mergePeriodoPersona(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> mergePeriodoCalculoPersona(final RunTareaDto runTarea) {
        runTareaConsolidarPeriodoService.mergePeriodoCalculoPersona(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> mergePeriodoLocalizacion(final RunTareaDto runTarea) {
        runTareaConsolidarPeriodoService.mergePeriodoLocalizacion(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> mergePeriodoLocalizacionPersona(final RunTareaDto runTarea) {
        runTareaConsolidarPeriodoService.mergePeriodoLocalizacionPersona(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
