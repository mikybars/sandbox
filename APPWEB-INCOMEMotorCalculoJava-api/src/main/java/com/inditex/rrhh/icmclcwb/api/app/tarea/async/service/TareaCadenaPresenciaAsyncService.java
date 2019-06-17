package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Async("repositoryPrimaryExecutor")
public interface TareaCadenaPresenciaAsyncService {

    CompletableFuture<Void> save(List<PtrPresenciaTotalizadoResultItemDto> dto, TareaDto tarea);

}
