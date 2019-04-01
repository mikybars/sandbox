package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

@Async("repositoryPrimaryExecutor")
public interface TareaTiendaEstadoAsyncService {

    CompletableFuture<Void> save(RunTareaRecolectarDto runTareaRecolectar, TareaDto tarea);

}
