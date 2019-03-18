package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;

public interface RunTareaRecolectarPtrVentaEmpleadoAsyncService {

    CompletableFuture<Void> ventaDetalleEmpleado(RunTareaDto runTarea,
            RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> ventaFisicaPersonaLocalizacionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaFisicaPersonaOperacionLocalizacionByRunTarea(final RunTareaDto runTarea);

}
