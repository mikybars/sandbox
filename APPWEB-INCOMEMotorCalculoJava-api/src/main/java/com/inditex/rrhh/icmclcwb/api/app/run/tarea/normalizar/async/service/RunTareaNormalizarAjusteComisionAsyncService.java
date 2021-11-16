package com.inditex.rrhh.icmclcwb.api.app.run.tarea.normalizar.async.service;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.springframework.scheduling.annotation.Async;

@Async
public interface RunTareaNormalizarAjusteComisionAsyncService {

  CompletableFuture<Void> normalizarAjusteComision(final TareaDto tarea);

}
