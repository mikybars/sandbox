package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaRecolectarMeta4IcmWsCalcIncomeAsyncService {

    CompletableFuture<Void> tiendasHistorico(final TareaDto tarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> tiendasEmpleadoHistorico(final TareaDto tarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> condicionesEmpleados(final TareaDto tarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> empleadosTienda(final TareaDto tarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> tiendasPresencia(final TareaDto tarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> tiendasComisionable(final TareaDto tarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

}