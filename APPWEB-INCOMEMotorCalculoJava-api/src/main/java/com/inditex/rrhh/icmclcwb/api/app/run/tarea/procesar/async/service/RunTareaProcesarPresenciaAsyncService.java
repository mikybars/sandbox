package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaProcesarPresenciaAsyncService {

    CompletableFuture<Void> updateActivoLocalizacionPersonaSeccionPresencia(RunTareaDto runTarea);

//    CompletableFuture<Void> updateActivoTotalizadoLocalizacion(RunTareaDto runTarea);

//    CompletableFuture<Void> compensarLocalizacion(RunTareaDto runTarea);

}
