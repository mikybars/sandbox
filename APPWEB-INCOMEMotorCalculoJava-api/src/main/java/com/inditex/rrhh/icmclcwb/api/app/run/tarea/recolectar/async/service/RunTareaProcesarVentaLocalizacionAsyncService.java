package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaProcesarVentaLocalizacionAsyncService {

  CompletableFuture<Void> ventaLocalizacionSeccion(final RunTareaDto runTarea);

  CompletableFuture<Void> ventaLocalizacionTienda(final RunTareaDto runTarea);

  CompletableFuture<Void> saveAbierto(final RunTareaDto runTarea);

  CompletableFuture<Void> saveCerrado(final RunTareaDto runTarea);

  CompletableFuture<Void> trasladar(final RunTareaDto runTarea);

}
