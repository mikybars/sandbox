package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import org.jspecify.annotations.NonNull;
import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionAbiertaAsyncService {

  CompletableFuture<Void> saveAbierto(@NonNull TareaDto tareaDto, @NonNull TrabajoDTO trabajoDto);

  CompletableFuture<Void> saveCerrado(@NonNull TareaDto tareaDto, @NonNull TrabajoDTO trabajoDto);

}
