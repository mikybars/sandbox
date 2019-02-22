package com.inditex.rrhh.icmclcwb.model.app.proceso.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoRecolectarMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class ProcesoRecolectarMeta4IcmWsCalcIncomeAsyncServiceImpl implements ProcesoRecolectarMeta4IcmWsCalcIncomeAsyncService {

    @Autowired
    private ProcesoRecolectarMeta4IcmWsCalcIncomeService procesoRecolectarMeta4IcmWsCalcIncomeService;

    @Async
    @Override
    public CompletableFuture<Void> tiendasPresencia(final ProcesoDto proceso,
            final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        procesoRecolectarMeta4IcmWsCalcIncomeService.tiendasPresencia(proceso, runProcesoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiendasComisionable(final ProcesoDto proceso, final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        procesoRecolectarMeta4IcmWsCalcIncomeService.tiendasComisionable(proceso, runProcesoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiendasHistorico(final ProcesoDto proceso,
            final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        procesoRecolectarMeta4IcmWsCalcIncomeService.tiendasHistorico(proceso, runProcesoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiendasEmpleadoHistorico(final ProcesoDto proceso,
            final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        procesoRecolectarMeta4IcmWsCalcIncomeService.tiendasEmpleadoHistorico(proceso, runProcesoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> condicionesEmpleados(final ProcesoDto proceso,
            final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        procesoRecolectarMeta4IcmWsCalcIncomeService.condicionesEmpleados(proceso, runProcesoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> empleadosTienda(final ProcesoDto proceso,
            final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        procesoRecolectarMeta4IcmWsCalcIncomeService.empleadosTienda(proceso, runProcesoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}