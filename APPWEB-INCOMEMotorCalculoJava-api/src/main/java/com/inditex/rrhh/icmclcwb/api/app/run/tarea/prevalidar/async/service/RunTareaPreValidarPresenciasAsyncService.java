/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.run.tarea.prevalidar.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaPrevalidarDto;

@Async
public interface RunTareaPreValidarPresenciasAsyncService {

    CompletableFuture<Void> run(@NotNull @Valid RunTareaPrevalidarDto runTareaPrevalidarDto);

}
