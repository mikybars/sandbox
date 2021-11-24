/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.calcular;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunAjusteAsync {

    @Async("algoritmoAjusteExecutor")
    CompletableFuture<Void> execute(RunTareaDto runTarea, AlgoritmoAjusteDto algoritmoAjuste);

    String getSqlCalcular(AlgoritmoAjusteDto algoritmoAjuste);

}
