package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.constraints.NotNull;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionAbiertaAsyncService {

    CompletableFuture<Void> saveAbierto(@NotNull TareaDto tareaDto, @NotNull TrabajoDTO trabajoDto);

    CompletableFuture<Void> saveCerrado(@NotNull TareaDto tareaDto, @NotNull TrabajoDTO trabajoDto);

}
