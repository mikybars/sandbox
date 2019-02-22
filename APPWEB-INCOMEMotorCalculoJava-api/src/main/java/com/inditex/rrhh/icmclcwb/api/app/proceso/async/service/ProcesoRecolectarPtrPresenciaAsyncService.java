package com.inditex.rrhh.icmclcwb.api.app.proceso.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;

public interface ProcesoRecolectarPtrPresenciaAsyncService {

    CompletableFuture<Void> tiposHoras(final ProcesoDto proceso,
            final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

    CompletableFuture<Void> presenciaDetalleEmpleado(final ProcesoDto proceso,
            final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

    CompletableFuture<Void> presenciaTotalizadaTienda(final ProcesoDto proceso,
            final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

}