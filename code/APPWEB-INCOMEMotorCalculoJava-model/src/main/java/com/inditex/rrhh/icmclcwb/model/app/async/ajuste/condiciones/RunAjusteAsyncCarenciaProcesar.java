package com.inditex.rrhh.icmclcwb.model.app.async.ajuste.condiciones;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.model.app.ajuste.condiciones.RunAjusteCarenciaProcesar;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjusteAsync;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("carenciaV1")
@RequiredArgsConstructor
public class RunAjusteAsyncCarenciaProcesar implements RunAjusteAsync {

  private final RunAjusteCarenciaProcesar runAjusteCarenciaProcesar;

  @Override
  public CompletableFuture<Void> execute(
      final RunTareaDto runTarea,
      final AlgoritmoAjusteDto algoritmoAjuste) {
    this.runAjusteCarenciaProcesar.execute(runTarea, algoritmoAjuste);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
