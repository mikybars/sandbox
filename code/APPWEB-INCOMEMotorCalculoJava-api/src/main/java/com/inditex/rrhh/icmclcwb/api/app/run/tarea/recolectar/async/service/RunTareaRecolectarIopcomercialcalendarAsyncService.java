package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import org.springframework.scheduling.annotation.Async;

@Async
public interface RunTareaRecolectarIopcomercialcalendarAsyncService {

  CompletableFuture<Void> horarioComercialFestivoByRunTarea(final RunTareaDto runTarea);

}
