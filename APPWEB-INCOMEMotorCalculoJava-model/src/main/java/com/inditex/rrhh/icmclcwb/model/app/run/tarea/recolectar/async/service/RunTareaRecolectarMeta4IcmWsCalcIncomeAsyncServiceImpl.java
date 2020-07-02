package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

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
    public CompletableFuture<Void> estructurasComByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.estructurasComByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> estructurasPolByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.estructurasPolByRunTarea(runTarea);
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
    public CompletableFuture<Void> empleadosDesplazamientoByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.empleadosDesplazamientoByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> ausenciasByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.ausenciasByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> configuracionesByRunTarea(RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.configuraciones(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> confChallengeDiasMinimosByRunTarea(RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.confChallengeDiasMinimosByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> presupuestosWlocByRunTarea(RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.presupuestosWlocByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> confPrecioHoraByRunTarea(RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.confPrecioHoraByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> confChallengeTipoVentaByRunTarea(RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.confChallengeTipoVentaByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> presupuestosRangoByRunTarea(RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.presupuestosRangoByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> ventaCongeladaByRunTarea(RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.ventaCongeladaByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}

