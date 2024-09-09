package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaProcesarJornadaAsyncService {

  CompletableFuture<Void> procesarJornadaLocalizacionPersona(RunTareaDto runTarea);

  CompletableFuture<Void> procesarJornadaLocalizacion(RunTareaDto runTarea);
}
