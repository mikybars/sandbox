package com.inditex.rrhh.icmclcwb.api.app.run.tarea.regularizar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import org.springframework.scheduling.annotation.Async;

@Async
public interface RunTareaRegularizarCalculoAsyncService {

  CompletableFuture<Void> regularizarCalculoMejorOpcion(RunTareaDto runTarea);

  CompletableFuture<Void> regularizarMejorOpcionSinFechas(RunTareaDto runTarea);

  CompletableFuture<Void> regularizarMejorOpcionSinFechasTodoPeriodo(RunTareaDto runTarea);

}
