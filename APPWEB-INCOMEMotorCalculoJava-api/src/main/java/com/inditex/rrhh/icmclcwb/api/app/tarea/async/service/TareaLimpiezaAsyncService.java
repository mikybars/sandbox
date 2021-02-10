/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;

/**
 * @author javierev
 */
@Async("repositoryPrimaryExecutor")
public interface TareaLimpiezaAsyncService {

    CompletableFuture<TareaLimpiezaDto> save(TareaLimpiezaDto tareaLimpieza);

    CompletableFuture<List<TareaLimpiezaDto>> save(List<IdTareaDto> idTareas);

}
