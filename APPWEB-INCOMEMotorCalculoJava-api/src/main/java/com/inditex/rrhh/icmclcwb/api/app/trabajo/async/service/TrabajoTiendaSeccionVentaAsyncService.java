package com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;

public interface TrabajoTiendaSeccionVentaAsyncService {

	CompletableFuture<Void> save(List<PtrVentaTotalizadoResultItemDto> dto, TrabajoDto trabajoDto);

	CompletableFuture<Void> save(PtrVentaTotalizadoResultItemDto dto, TrabajoDto trabajoDto);

}
