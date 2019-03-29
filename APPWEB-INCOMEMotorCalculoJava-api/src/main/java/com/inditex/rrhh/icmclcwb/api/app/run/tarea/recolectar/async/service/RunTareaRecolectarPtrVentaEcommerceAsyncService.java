package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaRecolectarPtrVentaEcommerceAsyncService {

    CompletableFuture<Void> ventaOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlineIpodLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlinePickingLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlineIpodLocalizacionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlinePickingLocalizacionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlineEntregaTiendaLocalizacionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlineEntregaDomicilioLocalizacionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlineIpodDetalleLocalizacionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlineIpodDetalleOperacionLocalizacionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlineIpodDetalleVendedorLocalizacionByRunTarea(final RunTareaDto runTarea);

}
