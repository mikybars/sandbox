package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

@Async
public interface RunTareaProcesarPresenciaAsyncService {

    CompletableFuture<Void> updateActivoLocalizacionPersonaPresencia(RunTareaDto runTarea);

    CompletableFuture<Void> compensarLocalizacion(RunTareaDto runTarea);

    CompletableFuture<Void> compensarLocalizacionEcommerce(RunTareaDto runTarea);

    CompletableFuture<Void> compensarLocalizacionPersonaPresencia(RunTareaDto runTarea);

    CompletableFuture<Void> totalizarLocalizacion(RunTareaDto runTarea);

    CompletableFuture<Void> calcularPresenciasTotalesAgrupacion(RunTareaDto runTarea);

    CompletableFuture<Void> updateActivoLocalizacionVacio(RunTareaDto runTarea);

    CompletableFuture<Void> updateActivoLocalizacionPersonaPresenciaVacio(RunTareaDto runTarea);

    CompletableFuture<Void> indicadorPresencia(RunTareaDto runTarea);

    CompletableFuture<Void> indicadorPresenciaDesplazamiento(RunTareaDto runTarea);
    
    CompletableFuture<Void> indicadorPresenciaDesplazamientoBase(RunTareaDto runTarea);

    CompletableFuture<Void> totalizarEcommerceLocalizacion(RunTareaDto runTarea);

}
