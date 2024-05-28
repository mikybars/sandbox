package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import jakarta.validation.constraints.NotNull;
import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionAbiertaAsyncService {

  CompletableFuture<Void> saveAbierto(@NotNull TareaDto tareaDto, @NotNull TrabajoDTO trabajoDto);

  CompletableFuture<Void> saveCerrado(@NotNull TareaDto tareaDto, @NotNull TrabajoDTO trabajoDto);

}
