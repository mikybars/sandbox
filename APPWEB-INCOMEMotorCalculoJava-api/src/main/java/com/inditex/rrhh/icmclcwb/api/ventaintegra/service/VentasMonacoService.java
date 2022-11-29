package com.inditex.rrhh.icmclcwb.api.ventaintegra.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface VentasMonacoService {

  CompletableFuture<Void> ventaFisicaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> ventaOnlineIpodLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> ventaOnlinePickingLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(final RunTareaDto runTarea);

}
