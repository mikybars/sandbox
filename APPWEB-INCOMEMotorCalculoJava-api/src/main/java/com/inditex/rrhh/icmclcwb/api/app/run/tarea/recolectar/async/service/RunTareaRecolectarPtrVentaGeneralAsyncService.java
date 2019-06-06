package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

@Async
public interface RunTareaRecolectarPtrVentaGeneralAsyncService {

    CompletableFuture<Void> ventaFisicaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

}