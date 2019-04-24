package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncServiceImpl
        implements RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService {

    @Autowired
    private RunTareaRecolectarMeta4IcmWsCalcIncomeService tareaRecolectarMeta4IcmWsCalcIncomeService;

    
    @Override
    public CompletableFuture<Void> tiendasPresencia(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.tiendasPresencia(runTarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    
    @Override
    public CompletableFuture<Void> tiendasComisionable(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.tiendasComisionable(runTarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    
    @Override
    public CompletableFuture<Void> tiendasHistorico(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.tiendasHistorico(runTarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    
    @Override
    public CompletableFuture<Void> localizacionHistoricoByRunTarea(RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.localizacionHistoricoByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    
    @Override
    public CompletableFuture<Void> tiendasEmpleadoHistorico(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.tiendasEmpleadoHistorico(runTarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    
    @Override
    public CompletableFuture<Void> condicionesEmpleados(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.condicionesEmpleados(runTarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    
    @Override
    public CompletableFuture<Void> empleadosTienda(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.empleadosTienda(runTarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    
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
    public CompletableFuture<Void> periodosByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarMeta4IcmWsCalcIncomeService.periodosByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
