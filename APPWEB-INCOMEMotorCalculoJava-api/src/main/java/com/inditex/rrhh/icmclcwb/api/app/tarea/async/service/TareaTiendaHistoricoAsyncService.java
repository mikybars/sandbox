package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaHistoricoDto;

public interface TareaTiendaHistoricoAsyncService {

	CompletableFuture<Void> save(final List<TareaTiendaHistoricoDto> tareaTiendaHistorico, final TareaDto tarea);

}
