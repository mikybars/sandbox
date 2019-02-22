package com.inditex.rrhh.icmclcwb.api.app.proceso.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaHistoricoDto;

public interface ProcesoTiendaHistoricoAsyncService {

	CompletableFuture<Void> save(final List<ProcesoTiendaHistoricoDto> procesoTiendaHistorico, final ProcesoDto proceso);

}
