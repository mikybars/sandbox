package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;

@Async("repositoryPrimaryExecutor")
public interface TareaPeriodoAsyncService {

    CompletableFuture<Void> save(List<PeriodosResultItemDto> src, TareaDto tarea);

}
