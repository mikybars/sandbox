package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaProcesarVentaAsyncService {
        
    CompletableFuture<Void> ventaLocalizacionSeccion(final RunTareaDto runTarea);
    
    CompletableFuture<Void> ventaLocalizacionTienda(final RunTareaDto runTarea);
    
    CompletableFuture<Void> ventaOnlineEntregaTiendaAgrupacionCadena(RunTareaDto runTarea);
    
    CompletableFuture<Void> ventaFisicaAgrupacionCadena(RunTareaDto runTarea);
    
    CompletableFuture<Void> ventaFisicaAgrupacionCadenaSeccion(@Valid RunTareaDto runTarea);
    
    CompletableFuture<Void> saveAbierto(RunTareaDto runTarea);
    
    CompletableFuture<Void> saveCerrado(RunTareaDto runTarea);
    
    CompletableFuture<Void> trasladar(RunTareaDto runTarea);

}
