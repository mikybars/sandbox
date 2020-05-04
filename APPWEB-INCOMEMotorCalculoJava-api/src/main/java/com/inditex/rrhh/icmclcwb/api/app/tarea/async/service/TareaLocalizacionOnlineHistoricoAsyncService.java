package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionOnlineHistoricoAsyncService {

    CompletableFuture<Void> save(final List<TiendaOnlineResultItemDto> src, final TareaDto tarea);

}
