package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaProcesarVentaLocalizacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaProcesarVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaProcesarVentaLocalizacionAsyncServiceImpl
        implements RunTareaProcesarVentaLocalizacionAsyncService {
    
    @Autowired
    private RunTareaProcesarVentaService tareaProcesarVentaService;

    @Async
    @Override
    public CompletableFuture<Void> ventaLocalizacionSeccion(RunTareaDto runTarea) {
        tareaProcesarVentaService.ventaLocalizacionSeccion(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> ventaLocalizacionTienda(RunTareaDto runTarea) {
        tareaProcesarVentaService.ventaLocalizacionTienda(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
