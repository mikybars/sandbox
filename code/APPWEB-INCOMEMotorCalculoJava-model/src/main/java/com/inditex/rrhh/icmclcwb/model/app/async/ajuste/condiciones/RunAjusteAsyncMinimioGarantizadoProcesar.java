package com.inditex.rrhh.icmclcwb.model.app.async.ajuste.condiciones;

import java.util.concurrent.CompletableFuture;

/*
 * Copyright (c) 2021. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.model.app.ajuste.condiciones.RunAjusteMinimoGarantizadoProcesar;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjusteAsync;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("minimoGarantizadoV1")
@RequiredArgsConstructor
public class RunAjusteAsyncMinimioGarantizadoProcesar implements RunAjusteAsync {

  private final RunAjusteMinimoGarantizadoProcesar runAjusteMinimoGarantizadoProcesar;

  @Override
  public CompletableFuture<Void> execute(
      final RunTareaDto runTarea,
      final AlgoritmoAjusteDto algoritmoAjuste) {
    this.runAjusteMinimoGarantizadoProcesar.execute(runTarea, algoritmoAjuste);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
