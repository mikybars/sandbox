package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Async("repositoryPrimaryExecutor")
public interface TareaPresupuestoAsyncService {

    CompletableFuture<Void> save(List<PresupuestosWlocResultItemDto> src, TareaDto tarea);

}
