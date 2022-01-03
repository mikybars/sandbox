package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import org.springframework.scheduling.annotation.Async;

@Async
public interface RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService {

  CompletableFuture<Void> personaByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> localizacionByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> empleadosPresenciaByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> empleadosDesplazamientoByRunTarea(final RunTareaDto runTarea);

}
