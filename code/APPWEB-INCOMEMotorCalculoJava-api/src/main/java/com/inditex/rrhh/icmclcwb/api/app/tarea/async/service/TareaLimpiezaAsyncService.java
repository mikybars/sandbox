package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;
import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;

import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaLimpiezaAsyncService {

  CompletableFuture<TareaLimpiezaDto> save(TareaLimpiezaDto tareaLimpieza);

  CompletableFuture<List<TareaLimpiezaDto>> save(List<IdTareaDTO> idTareas);

}
