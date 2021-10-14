/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.app.run.tarea.normalizar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

/**
 * @author javierev
 */
@Async
public interface RunTareaNormalizarAjusteComisionAsyncService {

    CompletableFuture<Void> normalizarAjusteComision(final TareaDto tarea);

}
