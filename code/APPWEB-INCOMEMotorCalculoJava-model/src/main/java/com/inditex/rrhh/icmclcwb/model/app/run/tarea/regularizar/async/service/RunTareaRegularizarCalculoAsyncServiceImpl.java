package com.inditex.rrhh.icmclcwb.model.app.run.tarea.regularizar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.regularizar.async.service.RunTareaRegularizarCalculoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.regularizar.service.RunTareaRegularizarCalculoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunTareaRegularizarCalculoAsyncServiceImpl implements RunTareaRegularizarCalculoAsyncService {

  @Autowired
  private RunTareaRegularizarCalculoService runTareaRegularizarService;

  @Override
  public CompletableFuture<Void> regularizarCalculoMejorOpcion(final RunTareaDto runTarea) {
    this.runTareaRegularizarService.regularizarCalculoMejorOpcion(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> regularizarMejorOpcionSinFechas(final RunTareaDto runTarea) {
    this.runTareaRegularizarService.regularizarMejorOpcionSinFechas(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> regularizarMejorOpcionSinFechasTodoPeriodo(final RunTareaDto runTarea) {
    this.runTareaRegularizarService.regularizarMejorOpcionSinFechasTodoPeriodo(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
