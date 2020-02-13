package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaProcesarVentaAsyncServiceImpl implements RunTareaProcesarVentaAsyncService {

    @Autowired
    private RunTareaProcesarVentaService tareaProcesarVentaService;

    @Override
    public CompletableFuture<Void> saveAbierto(RunTareaDto runTarea) {
        tareaProcesarVentaService.saveAbierto(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> saveAbiertoSeccion(RunTareaDto runTarea) {
        tareaProcesarVentaService.saveAbiertoSeccion(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> compensarOnlineSeccionCerrada(RunTareaDto runTarea) {
        tareaProcesarVentaService.compensarOnlineSeccionCerrada(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> saveCerrado(RunTareaDto runTarea) {
        tareaProcesarVentaService.saveCerrado(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> saveCerradoSeccion(RunTareaDto runTarea) {
        tareaProcesarVentaService.saveCerradoSeccion(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> trasladar(RunTareaDto runTarea) {
        tareaProcesarVentaService.trasladar(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> compensar(RunTareaDto runTarea) {
        tareaProcesarVentaService.compensar(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> repartoVentaEntregaDomicilioAgrupaciones(RunTareaDto runTarea) {
        tareaProcesarVentaService.repartoVentaEntregaDomicilioAgrupaciones(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> repartoVentaEntregaDomicilioPorPresenciaAgrupaciones(RunTareaDto runTarea) {
        tareaProcesarVentaService.repartoVentaEntregaDomicilioPorPresenciaAgrupaciones(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> repartoVentaEntregaDomicilioSeccion(RunTareaDto runTarea) {
        tareaProcesarVentaService.repartoVentaEntregaDomicilioSeccion(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> updateActivoTrasladadas(RunTareaDto runTarea) {
        tareaProcesarVentaService.updateActivoTrasladadas(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> updateActivoTrasladadasSeccion(RunTareaDto runTarea) {
        tareaProcesarVentaService.updateActivoTrasladadasSeccion(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> agruparOnlineSeccionDia(RunTareaDto runTarea) {
        tareaProcesarVentaService.agruparOnlineSeccionDia(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> updateActivoTrasladadasTotalizado(RunTareaDto runTarea) {
        tareaProcesarVentaService.updateActivoTrasladadasTotalizado(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> updateActivoNegativoTotalizado(RunTareaDto tarea) {
        tareaProcesarVentaService.updateActivoNegativoTotalizado(tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
