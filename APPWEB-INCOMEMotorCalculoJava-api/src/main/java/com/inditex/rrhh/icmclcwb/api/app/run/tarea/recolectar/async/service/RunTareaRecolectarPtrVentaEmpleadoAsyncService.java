package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaRecolectarPtrVentaEmpleadoAsyncService {

    CompletableFuture<Void> ventaFisicaDetalleLocalizacionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaFisicaDetalleOperacionLocalizacionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaFisicaDetalleOperacionVendedorLocalizacionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaFisicaDetalleVendedorLocalizacionByRunTarea(final RunTareaDto runTarea);

}
