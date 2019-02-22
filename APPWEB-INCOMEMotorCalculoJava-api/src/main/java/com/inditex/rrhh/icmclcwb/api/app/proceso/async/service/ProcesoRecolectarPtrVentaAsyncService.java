package com.inditex.rrhh.icmclcwb.api.app.proceso.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;

public interface ProcesoRecolectarPtrVentaAsyncService {

    CompletableFuture<Void> ventaDetalleEmpleado(final ProcesoDto proceso,
            final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

    CompletableFuture<Void> ventaTotalizadaTienda(final ProcesoDto proceso,
            final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

}