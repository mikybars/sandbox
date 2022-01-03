package com.inditex.rrhh.icmclcwb.api.app.test.service;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;

import org.springframework.scheduling.annotation.Async;

/**
 * Some javadoc.
 *
 * <p>Nota: esta clase se deberá borrar cuando se haya hecho la normalización de tareas consolidadas</p>
 *
 */
@Async
public interface TestNormalizacionAsyncService {

  CompletableFuture<Void> normalizarAjusteComision(List<IdTareaDTO> tareas);

}
