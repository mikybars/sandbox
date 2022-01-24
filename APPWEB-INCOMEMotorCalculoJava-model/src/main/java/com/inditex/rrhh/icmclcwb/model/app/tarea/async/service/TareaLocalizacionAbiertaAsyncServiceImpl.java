package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionAbiertaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionAbiertaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaLocalizacionAbiertaAsyncServiceImpl implements TareaLocalizacionAbiertaAsyncService {

  @Autowired
  private TareaLocalizacionAbiertaService tareaLocalizacionAbiertaService;

  @Override
  public CompletableFuture<Void> saveAbierto(@NotNull final TareaDto tareaDto, @NotNull final TrabajoDTO trabajoDto) {
    this.tareaLocalizacionAbiertaService.saveAbierto(tareaDto, trabajoDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> saveCerrado(@NotNull final TareaDto tareaDto, @NotNull final TrabajoDTO trabajoDto) {
    this.tareaLocalizacionAbiertaService.saveCerrado(tareaDto, trabajoDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
