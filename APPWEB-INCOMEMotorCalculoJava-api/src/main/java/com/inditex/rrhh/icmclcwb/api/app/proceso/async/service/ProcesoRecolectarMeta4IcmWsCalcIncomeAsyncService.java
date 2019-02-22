package com.inditex.rrhh.icmclcwb.api.app.proceso.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;

public interface ProcesoRecolectarMeta4IcmWsCalcIncomeAsyncService {

    CompletableFuture<Void> tiendasHistorico(final ProcesoDto proceso,
            final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

    CompletableFuture<Void> tiendasEmpleadoHistorico(final ProcesoDto proceso,
            final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

    CompletableFuture<Void> condicionesEmpleados(final ProcesoDto proceso,
            final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

    CompletableFuture<Void> empleadosTienda(final ProcesoDto proceso,
            final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

    CompletableFuture<Void> tiendasPresencia(final ProcesoDto proceso,
            final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

    CompletableFuture<Void> tiendasComisionable(final ProcesoDto proceso,
            final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

}