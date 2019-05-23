package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaRecolectarPtrPresenciaAsyncServiceImpl implements RunTareaRecolectarPtrPresenciaAsyncService {

    @Autowired
    private RunTareaRecolectarPtrPresenciaService tareaRecolectarPtrPresenciaService;

    @Override
    public CompletableFuture<Void> tiposHorasByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarPtrPresenciaService.tiposHorasByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> presenciaDetalleComisionablePersonaByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarPtrPresenciaService.presenciaDetalleComisionablePersonaByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> presenciaTotalLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarPtrPresenciaService.presenciaTotalLocalizacionSeccionByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> presenciaTotalLocalizacionByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarPtrPresenciaService.presenciaTotalLocalizacionByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> presenciaTiendaEmpleadoByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarPtrPresenciaService.presenciaTiendaEmpleadoByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> presenciaEmpleadoTiendaByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarPtrPresenciaService.presenciaEmpleadoTiendaByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> personaPresenciaDetalleComisionableByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarPtrPresenciaService.personaPresenciaDetalleComisionableByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}