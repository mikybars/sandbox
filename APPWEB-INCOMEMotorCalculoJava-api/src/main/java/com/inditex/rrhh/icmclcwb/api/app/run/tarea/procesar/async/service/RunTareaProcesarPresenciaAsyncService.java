package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

@Async
public interface RunTareaProcesarPresenciaAsyncService {

    CompletableFuture<Void> updateActivoLocalizacionPersonaPresencia(RunTareaDto runTarea);

    CompletableFuture<Void> updateActivoLocalizacion(RunTareaDto runTarea);

    CompletableFuture<Void> compensarLocalizacion(RunTareaDto runTarea);

    CompletableFuture<Void> compensarLocalizacionPersonaPresencia(RunTareaDto runTarea);

    CompletableFuture<Void> presenciasAgrupacionCadena(RunTareaDto runTarea);

}
