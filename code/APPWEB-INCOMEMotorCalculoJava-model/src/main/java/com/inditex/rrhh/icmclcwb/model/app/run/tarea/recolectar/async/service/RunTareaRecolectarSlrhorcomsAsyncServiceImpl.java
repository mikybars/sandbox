package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarSlrhorcomsAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarSlrhorcomsService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RunTareaRecolectarSlrhorcomsAsyncServiceImpl implements RunTareaRecolectarSlrhorcomsAsyncService {

  private final RunTareaRecolectarSlrhorcomsService runTareaRecolectarSlrhorcomsService;

  @Override
  public CompletableFuture<Void> horarioComercialFestivoByRunTarea(
      final RunTareaDto runTarea) {
    this.runTareaRecolectarSlrhorcomsService.horarioComercialFestivoByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
