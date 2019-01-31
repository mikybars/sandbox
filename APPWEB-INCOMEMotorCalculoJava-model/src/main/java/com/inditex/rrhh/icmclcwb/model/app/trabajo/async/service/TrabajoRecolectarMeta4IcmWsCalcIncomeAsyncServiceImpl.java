package com.inditex.rrhh.icmclcwb.model.app.trabajo.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoRecolectarMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class TrabajoRecolectarMeta4IcmWsCalcIncomeAsyncServiceImpl implements TrabajoRecolectarMeta4IcmWsCalcIncomeAsyncService {

    @Autowired
    private TrabajoRecolectarMeta4IcmWsCalcIncomeService trabajoRecolectarMeta4IcmWsCalcIncomeService;

    @Async
    @Override
    public CompletableFuture<Void> tiendasPresencia(final TrabajoDto trabajo,
            final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) throws Exception {
        trabajoRecolectarMeta4IcmWsCalcIncomeService.tiendasPresencia(trabajo, runTrabajoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiendasComisionable(final TrabajoDto trabajo, final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) throws Exception {
        trabajoRecolectarMeta4IcmWsCalcIncomeService.tiendasComisionable(trabajo, runTrabajoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiendasHistorico(final TrabajoDto trabajo,
            final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) throws Exception {
        trabajoRecolectarMeta4IcmWsCalcIncomeService.tiendasHistorico(trabajo, runTrabajoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiendasEmpleadoHistorico(final TrabajoDto trabajo,
            final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) throws Exception {
        trabajoRecolectarMeta4IcmWsCalcIncomeService.tiendasEmpleadoHistorico(trabajo, runTrabajoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> condicionesEmpleados(final TrabajoDto trabajo,
            final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) throws Exception {
        trabajoRecolectarMeta4IcmWsCalcIncomeService.condicionesEmpleados(trabajo, runTrabajoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> empleadosTienda(final TrabajoDto trabajo,
            final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) throws Exception {
        trabajoRecolectarMeta4IcmWsCalcIncomeService.empleadosTienda(trabajo, runTrabajoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}