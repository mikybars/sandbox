package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaAmbitoGlobalLocalizacionAsyncService {

  CompletableFuture<Void> mergeLocalizacion(RunTareaDto runTareaDto);

}
