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
    public CompletableFuture<Void> compensar(RunTareaDto runTarea) {
        runTareaProcesarPresenciaService.compensar(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> updateActivo(RunTareaDto runTarea) {
        runTareaProcesarPresenciaService.updateActivo(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
