package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import org.springframework.scheduling.annotation.Async;

@Async
public interface RunTareaRecolectarPtrVentaEcommerceAsyncService {

  CompletableFuture<Void> ventaOnlineEntregaDomicilioCadenaByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> ventaOnlineIpodLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> ventaOnlinePickingLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> ventaOnlineIpodLocalizacionPersonaByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> updateActivoVentaOnlineIpodByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> updateActivoVentaOnlinePickingByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> updateActivoVentaOnlineEntregaTiendaByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> updateActivoVentaOnlineEntregaDomicilioByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> ventaRangoOnlineIpodLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> ventaRangoOnlineSintLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

}
