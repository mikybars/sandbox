package com.inditex.rrhh.icmclcwb.model.app.calcular;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import org.springframework.scheduling.annotation.Async;

public interface RunAjuste {

  @Async("algoritmoAjusteExecutor")
  CompletableFuture<Void> execute(RunTareaDto runTarea, AlgoritmoAjusteDto algoritmoAjuste);

  String getSqlCalcular(AlgoritmoAjusteDto algoritmoAjuste);

}
