package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

@Async
public interface RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService {

    CompletableFuture<Void> personaByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> localizacionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> condicionPersonaByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> tiendasComisionableByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> presenciaManualByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> empleadosPresenciaByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> coefJornadaByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> festivosByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> flagCalculaByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> configuracionVentaOnlineByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> agrupacionesCadenaByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> localizacionesOnlineByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> estructurasDesplazamientoByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> estructurasPoliticasByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> empleadosDesplazamientoByRunTarea(final RunTareaDto runTarea);

}
