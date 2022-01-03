package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDesplazamientoRealDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealResultItemDto;

import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaPersonaEstructuraDesplazamientoRealAsyncService {

  CompletableFuture<Void> save(List<TareaPersonaEstructuraDesplazamientoRealDto> src, TareaDto tarea);

  CompletableFuture<Void> saveDesplazamientoRealResultItemDto(List<DesplazamientoRealResultItemDto> src,
      TareaDto tarea);

}
