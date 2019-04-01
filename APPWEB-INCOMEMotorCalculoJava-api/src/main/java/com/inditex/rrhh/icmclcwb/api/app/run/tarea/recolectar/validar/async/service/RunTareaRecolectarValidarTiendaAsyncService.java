package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

@Async
public interface RunTareaRecolectarValidarTiendaAsyncService {

    CompletableFuture<Void> run(@NotNull @Valid RunTareaDto runTarea);

}
