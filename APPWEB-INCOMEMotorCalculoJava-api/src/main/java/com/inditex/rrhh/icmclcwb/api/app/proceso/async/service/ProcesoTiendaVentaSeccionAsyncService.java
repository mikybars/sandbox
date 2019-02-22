package com.inditex.rrhh.icmclcwb.api.app.proceso.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;

public interface ProcesoTiendaVentaSeccionAsyncService {

    CompletableFuture<Void> pivot(final ProcesoDto proceso);

}
