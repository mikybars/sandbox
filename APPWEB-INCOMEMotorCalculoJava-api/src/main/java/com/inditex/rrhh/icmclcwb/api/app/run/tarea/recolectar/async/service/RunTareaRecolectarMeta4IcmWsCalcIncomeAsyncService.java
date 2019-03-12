package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;

public interface RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService {

    CompletableFuture<Void> tiendasHistorico(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> tiendasEmpleadoHistorico(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> condicionesEmpleados(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> empleadosTienda(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> tiendasPresencia(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> tiendasComisionable(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> personaByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> localizacionByRunTarea(final RunTareaDto runTarea);
    
    CompletableFuture<Void> condicionPersonaByRunTarea(final RunTareaDto runTarea);

}
