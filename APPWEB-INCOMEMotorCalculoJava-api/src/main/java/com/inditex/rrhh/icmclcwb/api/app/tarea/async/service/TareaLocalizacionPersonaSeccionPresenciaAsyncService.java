package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.constraints.NotNull;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionPersonaSeccionPresenciaAsyncService {

    CompletableFuture<Void> save(@NotNull List<GenericEmpleadoResultItemDto> src, @NotNull TareaDto tareaDto);

}
