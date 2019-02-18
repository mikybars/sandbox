package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaTiendaVentaSeccionAsyncService {

    CompletableFuture<Void> pivot(final TareaDto tarea);

}
