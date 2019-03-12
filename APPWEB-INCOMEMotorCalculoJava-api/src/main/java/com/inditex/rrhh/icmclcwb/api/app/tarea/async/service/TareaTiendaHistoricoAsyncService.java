package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

public interface TareaTiendaHistoricoAsyncService {

	CompletableFuture<Void> save(final List<TareaTiendaHistoricoDto> tareaTiendaHistorico, final TareaDto tarea);
    
    CompletableFuture<Void> saveGenericTiendaResultItemDto(final List<GenericTiendaResultItemDto> genericTiendaResultItemDto, final TareaDto tarea);

}
