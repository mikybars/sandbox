package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaRecolectarPtrPresenciaAsyncServiceImpl implements RunTareaRecolectarPtrPresenciaAsyncService {

    @Autowired
    private RunTareaRecolectarPtrPresenciaService tareaRecolectarPtrPresenciaService;

    @Async
    @Override
    public CompletableFuture<Void> tiposHorasByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarPtrPresenciaService.tiposHorasByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> presenciaTotalizadaTiendaSeccion(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarPtrPresenciaService.presenciaTotalizadaTiendaSeccion(runTarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> presenciaTotalizadaTienda(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarPtrPresenciaService.presenciaTotalizadaTienda(runTarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> presenciaDetalleComisionable(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarPtrPresenciaService.presenciaDetalleComisionable(runTarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Async
    @Override
    public CompletableFuture<Void> presenciaDetalleComisionablePersonaByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarPtrPresenciaService.presenciaDetalleComisionablePersonaByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> presenciaTotalLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarPtrPresenciaService.presenciaTotalLocalizacionSeccionByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}