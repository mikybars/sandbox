package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaRecolectarPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class TareaRecolectarPtrPresenciaAsyncServiceImpl implements TareaRecolectarPtrPresenciaAsyncService {

    @Autowired
    private TareaRecolectarPtrPresenciaService tareaRecolectarPtrPresenciaService;

    @Async
    @Override
    public CompletableFuture<Void> tiposHoras(final TareaDto tarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarPtrPresenciaService.tiposHoras(tarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> presenciaTotalizadaTienda(final TareaDto tarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarPtrPresenciaService.presenciaTotalizadaTienda(tarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> presenciaDetalleEmpleado(final TareaDto tarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarPtrPresenciaService.presenciaDetalleEmpleado(tarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}