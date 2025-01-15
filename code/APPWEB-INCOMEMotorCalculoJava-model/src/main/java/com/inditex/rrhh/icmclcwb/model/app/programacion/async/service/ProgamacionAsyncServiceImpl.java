package com.inditex.rrhh.icmclcwb.model.app.programacion.async.service;

/*
 * Copyright (c) 2021. Inditex
 */

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.programacion.async.service.ProgramacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgamacionAsyncServiceImpl implements ProgramacionAsyncService {

  private final ProgramacionService programacionService;

  @Override
  public CompletableFuture<Void> updateFechaSiguienteEjecucion(
      @NonNull @NotEmpty final List<ProgramacionDTO> programacion) {
    this.programacionService.updateFechaSiguienteEjecucion(programacion);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
