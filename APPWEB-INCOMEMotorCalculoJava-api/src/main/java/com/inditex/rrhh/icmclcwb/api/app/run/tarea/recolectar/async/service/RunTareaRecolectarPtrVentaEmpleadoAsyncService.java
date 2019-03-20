package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;

public interface RunTareaRecolectarPtrVentaEmpleadoAsyncService {

    CompletableFuture<Void> ventaDetalleEmpleado(RunTareaDto runTarea,
            RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> ventaFisicaDetalleLocalizacionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaFisicaDetalleOperacionLocalizacionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaFisicaDetalleOperacionVendedorLocalizacionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaFisicaDetalleVendedorLocalizacionByRunTarea(final RunTareaDto runTarea);

}
