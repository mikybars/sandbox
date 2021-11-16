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

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgamacionAsyncServiceImpl implements ProgramacionAsyncService {

  @Autowired
  private ProgramacionService programacionService;

  @Override
  public CompletableFuture<Void> updateFechaSiguienteEjecucion(
      @NotNull @NotEmpty final List<ProgramacionDTO> programacion) {
    this.programacionService.updateFechaSiguienteEjecucion(programacion);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
