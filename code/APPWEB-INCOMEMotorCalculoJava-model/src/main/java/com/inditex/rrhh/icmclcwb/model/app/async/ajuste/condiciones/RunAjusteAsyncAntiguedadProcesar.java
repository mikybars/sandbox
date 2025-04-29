package com.inditex.rrhh.icmclcwb.model.app.async.ajuste.condiciones;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.model.app.ajuste.condiciones.RunAjusteAntiguedadProcesar;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjusteAsync;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("antiguedadV1")
@RequiredArgsConstructor
public class RunAjusteAsyncAntiguedadProcesar implements RunAjusteAsync {

  private final RunAjusteAntiguedadProcesar runAjusteAntiguedadProcesar;

  @Override
  public CompletableFuture<Void> execute(
      final RunTareaDto runTarea,
      final AlgoritmoAjusteDto algoritmoAjuste) {
    this.runAjusteAntiguedadProcesar.execute(runTarea, algoritmoAjuste);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
