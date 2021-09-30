package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionPresupuestoAsyncService {

    CompletableFuture<Void> save(List<PresupuestosWlocResultItemDto> src, TareaDto tarea);

}
