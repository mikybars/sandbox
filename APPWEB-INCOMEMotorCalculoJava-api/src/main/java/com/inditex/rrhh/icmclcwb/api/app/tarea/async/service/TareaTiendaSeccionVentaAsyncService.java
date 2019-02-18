package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;

public interface TareaTiendaSeccionVentaAsyncService {

	CompletableFuture<Void> save(final List<PtrVentaTotalizadoResultItemDto> item, final TareaDto tarea);

	CompletableFuture<Void> save(final PtrVentaTotalizadoResultItemDto item, final TareaDto tarea);

}
