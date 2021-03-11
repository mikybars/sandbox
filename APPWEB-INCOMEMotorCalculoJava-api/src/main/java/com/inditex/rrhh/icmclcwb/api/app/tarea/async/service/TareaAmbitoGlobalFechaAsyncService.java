package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalFechaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

@Async("repositoryPrimaryExecutor")
public interface TareaAmbitoGlobalFechaAsyncService {

    CompletableFuture<Void> save(@Valid @NotNull TareaAmbitoGlobalFechaDto src,
            @Valid @NotNull TareaDto tarea);

}
