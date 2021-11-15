package com.inditex.rrhh.icmclcwb.api.app.run.tarea.regularizar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

@Async
public interface RunTareaRegularizarCalculoAsyncService {

    CompletableFuture<Void> regularizarCalculoMejorOpcion(RunTareaDto runTarea);

    CompletableFuture<Void> regularizarMejorOpcionSinFechas(RunTareaDto runTarea);

    CompletableFuture<Void> regularizarMejorOpcionSinFechasTodoPeriodo(RunTareaDto runTarea);

}
