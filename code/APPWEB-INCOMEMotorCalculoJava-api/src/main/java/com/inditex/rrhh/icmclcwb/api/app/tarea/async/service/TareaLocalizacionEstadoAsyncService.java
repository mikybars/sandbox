package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionEstadoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocResultItemDto;

import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionEstadoAsyncService {

  CompletableFuture<Void> save(List<TareaLocalizacionEstadoDto> tareaLocalizacionEstadoDto,
      TareaDto tarea);

  CompletableFuture<Void> saveEstadoWlocResultItemDto(
      List<EstadoWlocResultItemDto> estadoWlocResultItemDto, TareaDto tarea);
}
