package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;

import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionOnlineHistoricoAsyncService {

  CompletableFuture<Void> save(final List<TiendaOnlineResultItemDto> src, final TareaDto tarea);

}
