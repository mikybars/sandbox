package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionComisionHistoricoAsyncService {

  CompletableFuture<Void> save(List<TareaLocalizacionComisionHistoricoDto> tareaTiendaComisionHistoricoDto,
      TareaDto tarea);

  CompletableFuture<Void> saveGenericTiendaResultItemDto(List<GenericTiendaResultItemDto> genericTiendaResultItemDto,
      TareaDto tarea);

}
