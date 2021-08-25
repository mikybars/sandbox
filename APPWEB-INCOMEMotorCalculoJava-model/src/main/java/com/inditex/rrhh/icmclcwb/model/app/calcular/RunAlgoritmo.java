package com.inditex.rrhh.icmclcwb.model.app.calcular;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunAlgoritmo {

    @Async("algoritmoCalculoExecutor")
    CompletableFuture<Void> execute(RunTareaDto runTarea, AlgoritmoDto algoritmo);

    String getSqlCalcular(AlgoritmoDto algoritmo);

}
