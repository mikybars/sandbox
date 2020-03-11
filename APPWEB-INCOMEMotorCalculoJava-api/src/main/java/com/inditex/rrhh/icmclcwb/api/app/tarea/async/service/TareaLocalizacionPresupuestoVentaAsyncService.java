package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoVentaDto;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionPresupuestoVentaAsyncService {

    CompletableFuture<Void> save(List<TareaLocalizacionPresupuestoVentaDto> dto);

}
