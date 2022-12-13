package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaRecolectarPtrMonacoAsyncService {

  CompletableFuture<Void> presenciaDetallePersonaIncluidoCommerceByRunTarea(RunTareaDto runTarea);

  CompletableFuture<Void> presenciaDetalleComisionablePersonaByRunTarea(RunTareaDto runTarea);

  CompletableFuture<Void> ventaFisicaLocalizacionSeccionByRunTarea(RunTareaDto runTarea);

  CompletableFuture<Void> ventaOnlinePickingLocalizacionSeccionByRunTarea(RunTareaDto runTarea);

  CompletableFuture<Void> ventaOnlineIpodLocalizacionSeccionByRunTarea(RunTareaDto runTarea);

  CompletableFuture<Void> ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(RunTareaDto runTarea);

  CompletableFuture<Void> ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(RunTareaDto runTarea);
}
