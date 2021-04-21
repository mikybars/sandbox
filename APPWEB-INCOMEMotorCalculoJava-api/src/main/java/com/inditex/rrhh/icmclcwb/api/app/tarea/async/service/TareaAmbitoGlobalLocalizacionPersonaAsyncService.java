package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

@Async("repositoryPrimaryExecutor")
public interface TareaAmbitoGlobalLocalizacionPersonaAsyncService {

    CompletableFuture<Void> mergePersonaLocalizacion(RunTareaDto tarea);

}
