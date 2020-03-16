package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

@Async
public interface RunTareaProcesarCondicionesAsyncService {

    CompletableFuture<Void> updateImporteEstructuraPoliticas(RunTareaDto runTarea);

    CompletableFuture<Void> updateActivoPresupuestosBandaExcepcion(RunTareaDto runTarea);

    CompletableFuture<Void> updateActivoPresupuestosBandasSinExcepcion(RunTareaDto runTarea);

    CompletableFuture<Void> updateActivoEstructurasTopes(final TareaDto tarea);

}
