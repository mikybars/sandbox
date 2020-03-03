package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.async.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarEstructurasAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarEstructuraService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class RunTareaProcesarEstructurasAsyncServiceImpl implements RunTareaProcesarEstructurasAsyncService {

    @Autowired
    private RunTareaProcesarEstructuraService runTareaProcesarEstructuraService;

    @Override
    public CompletableFuture<Void> updateActivoTopes(TareaDto tarea) {
        runTareaProcesarEstructuraService.updateActivoTopes(tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
