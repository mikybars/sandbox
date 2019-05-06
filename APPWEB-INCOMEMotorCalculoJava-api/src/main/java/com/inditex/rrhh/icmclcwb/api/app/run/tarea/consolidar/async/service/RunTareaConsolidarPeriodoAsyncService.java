package com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

@Async
public interface RunTareaConsolidarPeriodoAsyncService {

    CompletableFuture<Void> mergePeriodoPersona(RunTareaDto runTarea);

    CompletableFuture<Void> mergePeriodoCalculoPersona(RunTareaDto runTarea);

    CompletableFuture<Void> mergePeriodoLocalizacion(RunTareaDto runTarea);

    CompletableFuture<Void> mergePeriodoLocalizacionPersona(RunTareaDto runTarea);

}
