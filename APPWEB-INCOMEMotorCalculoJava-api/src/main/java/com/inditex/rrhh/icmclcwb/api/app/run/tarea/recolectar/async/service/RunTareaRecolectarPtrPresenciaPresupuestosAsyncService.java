package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

@Async
public interface RunTareaRecolectarPtrPresenciaPresupuestosAsyncService {

    CompletableFuture<Void> presenciaEmpleadoTiendaByRunTarea(final RunTareaDto runTarea);

}
