package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import org.springframework.scheduling.annotation.Async;

@Async
public interface RunTareaRecolectarPtrVentaGeneralAsyncService {

  CompletableFuture<Void> ventaFisicaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> ventaFisicaCadenaByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> ventaRangoFisicaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> devolucionRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(
      final RunTareaDto runTarea);

  CompletableFuture<Void> devolucionVentaOriginalOtraTiendaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(
      final RunTareaDto runTarea);

  CompletableFuture<Void> ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(final RunTareaDto runTarea);

}
