package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

@Async
public interface RunTareaRecolectarPtrVentaEcommerceAsyncService {

    CompletableFuture<Void> ventaOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlineIpodLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlinePickingLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlineIpodDetalleOperacionLocalizacionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlineIpodDetalleVendedorLocalizacionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlineIpodDetalleLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

}
