package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaRecolectarMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class TareaRecolectarMeta4IcmWsCalcIncomeAsyncServiceImpl implements TareaRecolectarMeta4IcmWsCalcIncomeAsyncService {

    @Autowired
    private TareaRecolectarMeta4IcmWsCalcIncomeService tareaRecolectarMeta4IcmWsCalcIncomeService;

    @Async
    @Override
    public CompletableFuture<Void> tiendasPresencia(final TareaDto tarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.tiendasPresencia(tarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiendasComisionable(final TareaDto tarea, final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.tiendasComisionable(tarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiendasHistorico(final TareaDto tarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.tiendasHistorico(tarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiendasEmpleadoHistorico(final TareaDto tarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.tiendasEmpleadoHistorico(tarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> condicionesEmpleados(final TareaDto tarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.condicionesEmpleados(tarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> empleadosTienda(final TareaDto tarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.empleadosTienda(tarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}