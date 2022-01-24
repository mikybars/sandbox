package com.inditex.rrhh.icmclcwb.model.app.async.ajuste.condiciones;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.model.app.ajuste.condiciones.RunAjusteCarenciaProcesar;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjusteAsync;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("carenciaV1")
public class RunAjusteAsyncCarenciaProcesar implements RunAjusteAsync {

  @Autowired
  private RunAjusteCarenciaProcesar runAjusteCarenciaProcesar;

  @Override
  public CompletableFuture<Void> execute(
      final RunTareaDto runTarea,
      final AlgoritmoAjusteDto algoritmoAjuste) {
    this.runAjusteCarenciaProcesar.execute(runTarea, algoritmoAjuste);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
