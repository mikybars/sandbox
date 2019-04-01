package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

@Async
public interface RunTareaRecolectarValidarPersonaAsyncService {

    CompletableFuture<Void> run(RunTareaDto runTarea);

}
