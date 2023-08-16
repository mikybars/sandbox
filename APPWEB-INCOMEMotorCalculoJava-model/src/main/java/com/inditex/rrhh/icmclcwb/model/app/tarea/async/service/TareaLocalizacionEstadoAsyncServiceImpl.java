package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionEstadoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocResultItemDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaLocalizacionEstadoAsyncServiceImpl implements TareaLocalizacionEstadoAsyncService {

  @Autowired
  private TareaLocalizacionEstadoService tareaLocalizacionEstadoService;

  @Override
  public CompletableFuture<Void> save(final List<TareaLocalizacionEstadoDto> tareaLocalizacionEstadoDto,
      final TareaDto tarea) {
    this.tareaLocalizacionEstadoService.save(tareaLocalizacionEstadoDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> saveEstadoWlocResultItemDto(
      final List<EstadoWlocResultItemDto> estadoWlocResultItemDto, final TareaDto tarea) {
    this.tareaLocalizacionEstadoService
        .save(this.tareaLocalizacionEstadoService.merge(estadoWlocResultItemDto, tarea));
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
