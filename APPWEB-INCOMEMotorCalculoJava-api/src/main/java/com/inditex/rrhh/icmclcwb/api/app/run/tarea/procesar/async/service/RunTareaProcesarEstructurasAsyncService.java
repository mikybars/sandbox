package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

@Async
public interface RunTareaProcesarEstructurasAsyncService {

    CompletableFuture<Void> updateActivoTopes(final TareaDto tarea);

}
