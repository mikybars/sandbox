package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

@Async
public interface RunTareaRecolectarPtrVentaEcommerceAsyncService {

    CompletableFuture<Void> ventaOnlineEntregaDomicilioCadenaByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlineIpodLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlinePickingLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> updateActivoVentaOnlineIpodByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> updateActivoVentaOnlinePickingByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> updateActivoVentaOnlineEntregaTiendaByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> updateActivoVentaOnlineEntregaDomicilioByRunTarea(final RunTareaDto runTarea);

}
