package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaRecolectarPivotAsyncService {

    @Deprecated
    CompletableFuture<Void> pivot(@Valid final RunTareaDto runTarea);

}
