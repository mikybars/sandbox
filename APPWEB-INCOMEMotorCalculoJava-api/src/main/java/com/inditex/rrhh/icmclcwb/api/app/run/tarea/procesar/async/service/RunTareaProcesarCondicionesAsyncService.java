package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.springframework.scheduling.annotation.Async;

@Async
public interface RunTareaProcesarCondicionesAsyncService {

  CompletableFuture<Void> updateImporteEstructuraPoliticas(RunTareaDto runTarea);

  CompletableFuture<Void> updateActivoPresupuestosBandaExcepcion(RunTareaDto runTarea);

  CompletableFuture<Void> updateActivoPresupuestosBandasSinExcepcion(RunTareaDto runTarea);

  CompletableFuture<Void> updateActivoEstructurasTopes(final TareaDto tarea);

  CompletableFuture<Void> relacionarPresupuestosEstructurasSinDesplazamiento(final TareaDto tarea);

  CompletableFuture<Void> relacionarPresupuestosEstructurasDesplazamiento(final TareaDto tarea);

  CompletableFuture<Void> desactivarChallengeOpcionOrigen(final RunTareaDto runTarea);

  CompletableFuture<Void> crearChallengeOpcionOrigen(final RunTareaDto runTarea);

  CompletableFuture<Void> igualarBandasOrigenDestino(final RunTareaDto runTarea);

  CompletableFuture<Void> desactivarManualOrdinalDoble(final RunTareaDto runTarea);

  CompletableFuture<Void> establecerBandaOpcionOrigen(final RunTareaDto runTarea);

  CompletableFuture<Void> desactivarGlobalSeccionOpcionOrigen(RunTareaDto runTarea);

  CompletableFuture<Void> crearGlobalSeccionOpcionOrigen(RunTareaDto runTarea);
}
