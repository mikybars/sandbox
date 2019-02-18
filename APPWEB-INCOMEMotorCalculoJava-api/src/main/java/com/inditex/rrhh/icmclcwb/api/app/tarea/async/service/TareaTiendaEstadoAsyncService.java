package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTareaRecolectarDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaTiendaEstadoAsyncService {

    CompletableFuture<Void> save(RunTareaRecolectarDto runTareaRecolectar, TareaDto tarea);

}
