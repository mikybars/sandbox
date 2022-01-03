package com.inditex.rrhh.icmclcwb.model.app.test.service;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.test.service.TestNormalizacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestNormalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Some Javadoc.
 *
 * <p>Nota: esta clase se deberá borrar cuando se haya hecho la normalización de tareas consolidadas</p>
 *
 */
@Service
public class TestNormalizacionAsyncServiceImpl implements TestNormalizacionAsyncService {

  @Autowired
  private TestNormalizacionService testNormalizacionService;

  @Override
  public CompletableFuture<Void> normalizarAjusteComision(
      final List<IdTareaDTO> tareas) {
    this.testNormalizacionService.normalizarAjusteComision(tareas);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
