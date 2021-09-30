package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;

@Async("repositoryPrimaryExecutor")
public interface TareaAgrupacionCadenaAsyncService {

    CompletableFuture<Void> save(final List<AgrupOnlineResultItemDto> src, final TareaDto tarea);

}
