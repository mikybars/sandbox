package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarIopcomercialcalendarAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarIopcomercialcalendarService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RunTareaRecolectarIopcomercialcalendarAsyncServiceImpl implements RunTareaRecolectarIopcomercialcalendarAsyncService {

  private final RunTareaRecolectarIopcomercialcalendarService runTareaRecolectarIopcomercialcalendarService;

  @Override
  public CompletableFuture<Void> horarioComercialFestivoByRunTarea(
      final RunTareaDto runTarea) {
    this.runTareaRecolectarIopcomercialcalendarService.horarioComercialFestivoByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
