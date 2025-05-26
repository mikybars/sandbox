package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionPrecioHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.rest.client.dto.ConfiguracionPrecioHoraResponseDTO;

import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaConfiguracionPrecioHoraAsyncService {

  CompletableFuture<Void> save(List<TareaConfiguracionPrecioHoraDto> src, TareaDto tarea);

  CompletableFuture<Void> saveConfiguracionPrecioHoraResponseDTO(List<ConfiguracionPrecioHoraResponseDTO> src, TareaDto tarea);

}
