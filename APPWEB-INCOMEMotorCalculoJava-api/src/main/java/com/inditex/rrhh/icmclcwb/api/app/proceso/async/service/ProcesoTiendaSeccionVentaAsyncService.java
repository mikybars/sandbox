package com.inditex.rrhh.icmclcwb.api.app.proceso.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;

public interface ProcesoTiendaSeccionVentaAsyncService {

	CompletableFuture<Void> save(final List<PtrVentaTotalizadoResultItemDto> item, final ProcesoDto proceso);

	CompletableFuture<Void> save(final PtrVentaTotalizadoResultItemDto item, final ProcesoDto proceso);

}
