/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.app.test.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;

/**
 * Nota: esta clase se deberá borrar cuando se haya hecho la normalización de tareas consolidadas
 *
 * @author javierev
 */
@Async
public interface TestNormalizacionAsyncService {

    CompletableFuture<Void> normalizarAjusteComision(List<IdTareaDTO> tareas);

}
