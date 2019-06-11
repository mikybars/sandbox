package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaProcesarPresenciaAsyncServiceImpl implements RunTareaProcesarPresenciaAsyncService {

    @Autowired
    private RunTareaProcesarPresenciaService runTareaProcesarPresenciaService;
    
    @Override
    public CompletableFuture<Void> compensarLocalizacion(RunTareaDto runTarea) {
        runTareaProcesarPresenciaService.compensarLocalizacion(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> updateActivoLocalizacionPersonaPresencia(RunTareaDto runTarea) {
        runTareaProcesarPresenciaService.updateActivoLocalizacionPersonaPresencia(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> updateActivoTotalizadoLocalizacionPersonaPresencia(RunTareaDto runTarea) {
        runTareaProcesarPresenciaService.updateActivoTotalizadoLocalizacionPersonaPresencia(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> compensarLocalizacionPersonaPresencia(RunTareaDto runTarea) {
        runTareaProcesarPresenciaService.compensarLocalizacionPersonaPresencia(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> updateActivoLocalizacion(RunTareaDto runTarea) {
        runTareaProcesarPresenciaService.updateActivoLocalizacion(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> updateActivoTotalizadoLocalizacion(RunTareaDto runTarea) {
        runTareaProcesarPresenciaService.updateActivoTotalizadoLocalizacion(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
