package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoDTO;

import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaPersonaHistoricoAsyncService {

  CompletableFuture<Void> saveGenericEmpleadoResultItemDto(
      final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto, final TareaDto tarea);

  CompletableFuture<Void> save(final List<TareaPersonaHistoricoDto> tareaPersonaHistorico, final TareaDto tarea);

  CompletableFuture<Void> saveEmpleadoDto(final List<EmpleadoDTO> empleadoDtoList, final TareaDto tareaDto);

}
