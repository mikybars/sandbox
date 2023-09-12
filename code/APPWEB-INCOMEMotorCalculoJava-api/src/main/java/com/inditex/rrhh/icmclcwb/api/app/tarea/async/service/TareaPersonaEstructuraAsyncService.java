package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;

import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaPersonaEstructuraAsyncService {

  CompletableFuture<Void> save(final List<TareaPersonaEstructuraDto> tareaPersonaEstructura, final TareaDto tareaDto);

  CompletableFuture<Void> saveEstructurasComResultItemDto(
      final List<EstructurasComResultItemDto> estructurasComResultItemDto, final TareaDto tareaDto);

}
