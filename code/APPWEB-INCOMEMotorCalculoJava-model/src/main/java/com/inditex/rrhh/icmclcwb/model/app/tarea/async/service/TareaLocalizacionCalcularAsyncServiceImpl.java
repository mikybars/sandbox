package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionCalcularAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaLocalizacionCalcularAsyncServiceImpl implements TareaLocalizacionCalcularAsyncService {

  @Autowired
  private TareaLocalizacionCalcularService tareaLocalizacionCalcularService;

  @Override
  public CompletableFuture<Void> save(@NonNull List<GenericTiendaResultItemDto> src, @NonNull TareaDto tareaDto) {
    tareaLocalizacionCalcularService.save(src, tareaDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
