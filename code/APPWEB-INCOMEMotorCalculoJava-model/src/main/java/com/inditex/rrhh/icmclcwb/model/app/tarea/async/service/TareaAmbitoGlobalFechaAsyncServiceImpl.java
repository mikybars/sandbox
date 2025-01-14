package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalFechaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalFechaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalFechaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaAmbitoGlobalFechaAsyncServiceImpl implements TareaAmbitoGlobalFechaAsyncService {

  @Autowired
  private TareaAmbitoGlobalFechaService tareaAmbitoGlobalFechaService;

  @Override
  public CompletableFuture<Void> save(@Valid @NonNull final TareaAmbitoGlobalFechaDto src,
      @Valid @NonNull final TareaDto tarea) {
    this.tareaAmbitoGlobalFechaService.save(src, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
