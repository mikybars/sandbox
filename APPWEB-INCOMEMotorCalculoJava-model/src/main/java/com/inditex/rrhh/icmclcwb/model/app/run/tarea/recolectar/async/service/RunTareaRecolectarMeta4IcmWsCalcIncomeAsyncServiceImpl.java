package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncServiceImpl
    implements RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService {

    @Autowired
    private RunTareaRecolectarMeta4IcmWsCalcIncomeService tareaRecolectarMeta4IcmWsCalcIncomeService;

    @Override
    public CompletableFuture<Void> personaByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.personaByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> localizacionByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.localizacionByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> condicionPersonaByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.condicionPersonaByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> tiendasComisionableByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.tiendasComisionableByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> presenciaManualByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.presenciaManualByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> empleadosPresenciaByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.empleadosPresenciaByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> coefJornadaByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.coefJornadaByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> festivosByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.festivosByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> flagCalculaByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.flagCalculaByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> configuracionVentaOnlineByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.configuracionVentaOnlineByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> agrupacionesCadenaByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.agrupacionesCadenaByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> localizacionesOnlineByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.localizacionesOnlineByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> estructurasPoliticasByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.estructurasPoliticasByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> empleadosDesplazamientoByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.empleadosDesplazamientoByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
