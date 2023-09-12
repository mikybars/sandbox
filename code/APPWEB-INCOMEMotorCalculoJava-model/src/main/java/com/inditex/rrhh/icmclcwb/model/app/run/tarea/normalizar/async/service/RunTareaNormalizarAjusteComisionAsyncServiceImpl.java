package com.inditex.rrhh.icmclcwb.model.app.run.tarea.normalizar.async.service;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.normalizar.async.service.RunTareaNormalizarAjusteComisionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.normalizar.service.RunTareaNormalizarAjusteComisionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunTareaNormalizarAjusteComisionAsyncServiceImpl implements
    RunTareaNormalizarAjusteComisionAsyncService {

  @Autowired
  private RunTareaNormalizarAjusteComisionService runTareaNormalizarAjusteComisionService;

  @Override
  public CompletableFuture<Void> normalizarAjusteComision(
      final TareaDto tarea) {
    this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
