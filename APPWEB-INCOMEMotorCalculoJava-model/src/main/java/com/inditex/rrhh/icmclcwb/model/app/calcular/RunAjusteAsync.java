package com.inditex.rrhh.icmclcwb.model.app.calcular;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import org.springframework.scheduling.annotation.Async;

public interface RunAjusteAsync {

  @Async("algoritmoAjusteExecutor")
  CompletableFuture<Void> execute(RunTareaDto runTarea, AlgoritmoAjusteDto algoritmoAjuste);

}
