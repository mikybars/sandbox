package com.inditex.rrhh.icmclcwb.model.app.calcular;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

import org.springframework.scheduling.annotation.Async;

public interface RunAlgoritmo {

  @Async("algoritmoCalculoExecutor")
  CompletableFuture<Void> execute(RunTareaDto runTarea, AlgoritmoDTO algoritmo);

  String getSqlCalcular(AlgoritmoDTO algoritmo);

}
