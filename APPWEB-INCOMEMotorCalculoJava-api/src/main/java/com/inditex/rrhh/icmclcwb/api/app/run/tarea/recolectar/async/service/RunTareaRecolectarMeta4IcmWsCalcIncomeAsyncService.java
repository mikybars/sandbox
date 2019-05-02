package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

@Async
public interface RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService {

    CompletableFuture<Void> personaByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> localizacionByRunTarea(final RunTareaDto runTarea);
    
    CompletableFuture<Void> localizacionHistoricoByRunTarea(final RunTareaDto runTarea);
    
    CompletableFuture<Void> condicionPersonaByRunTarea(final RunTareaDto runTarea);
    
    CompletableFuture<Void> tiendasComisionableByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> periodosByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> presenciaManualByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> empleadosPresenciaByRunTarea(final RunTareaDto runTarea);

}
