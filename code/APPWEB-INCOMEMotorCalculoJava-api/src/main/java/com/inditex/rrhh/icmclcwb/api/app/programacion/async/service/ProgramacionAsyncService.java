package com.inditex.rrhh.icmclcwb.api.app.programacion.async.service;

/*
 * Copyright (c) 2021. Inditex
 */

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;

import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;
import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface ProgramacionAsyncService {

  CompletableFuture<Void> updateFechaSiguienteEjecucion(
      @NonNull @NotEmpty final List<ProgramacionDTO> idProgramacion);

}
