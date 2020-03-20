package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaGeneralAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaGeneralService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaRecolectarPtrVentaGeneralAsyncServiceImpl
        implements RunTareaRecolectarPtrVentaGeneralAsyncService {

    @Autowired
    private RunTareaRecolectarPtrVentaGeneralService tareaRecolectarPtrVentaService;

    @Override
    public CompletableFuture<Void> ventaFisicaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarPtrVentaService.ventaFisicaLocalizacionSeccionByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> ventaFisicaCadenaByRunTarea(RunTareaDto runTarea) {
        tareaRecolectarPtrVentaService.ventaFisicaCadenaByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> ventaRangoFisicaLocalizacionSeccionByRunTarea(RunTareaDto runTarea) {
        tareaRecolectarPtrVentaService.ventaRangoFisicaLocalizacionSeccionByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
