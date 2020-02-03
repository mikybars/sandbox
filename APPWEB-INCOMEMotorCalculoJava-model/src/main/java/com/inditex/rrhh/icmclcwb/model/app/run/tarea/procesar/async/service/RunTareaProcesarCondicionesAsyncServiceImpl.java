package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarCondicionesAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaProcesarCondicionesAsyncServiceImpl implements RunTareaProcesarCondicionesAsyncService {

    @Autowired
    private RunTareaProcesarVentaService tareaProcesarVentaService;
    
    @Override
    public CompletableFuture<Void> updateImporteEstructuraPoliticas(RunTareaDto runTarea) {
        tareaProcesarVentaService.updateImporteEstructuraPoliticas(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
