package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarCondicionesService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarCondicionesAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaProcesarCondicionesAsyncServiceImpl implements RunTareaProcesarCondicionesAsyncService {

    @Autowired
    private RunTareaProcesarVentaService tareaProcesarVentaService;

    @Autowired
    private RunTareaProcesarCondicionesService tareaProcesarCondicionesService;

    @Override
    public CompletableFuture<Void> updateImporteEstructuraPoliticas(RunTareaDto runTarea) {
        tareaProcesarVentaService.updateImporteEstructuraPoliticas(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> updateActivoPresupuestosBandaExcepcion(RunTareaDto runTarea) {
        tareaProcesarCondicionesService.updateActivoPresupuestosBandaExcepcion(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> updateActivoPresupuestosBandasSinExcepcion(RunTareaDto runTarea) {
        tareaProcesarCondicionesService.updateActivoPresupuestosBandasSinExcepcion(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> updateActivoEstructurasTopes(TareaDto tarea) {
        tareaProcesarCondicionesService.updateActivoEstructuraTopes(tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
