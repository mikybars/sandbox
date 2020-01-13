package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;

@Async("repositoryPrimaryExecutor")
public interface TareaPersonaAusenciaHistoricoAsyncService {

    CompletableFuture<Void> saveAusenciaResultItemDto(final List<AusenciasResultItemDto> src, final TareaDto tarea);

}
