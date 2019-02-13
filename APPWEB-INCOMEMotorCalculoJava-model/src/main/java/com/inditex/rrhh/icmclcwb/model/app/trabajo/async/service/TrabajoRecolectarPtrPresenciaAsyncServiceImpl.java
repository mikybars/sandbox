package com.inditex.rrhh.icmclcwb.model.app.trabajo.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoRecolectarPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class TrabajoRecolectarPtrPresenciaAsyncServiceImpl implements TrabajoRecolectarPtrPresenciaAsyncService {

    @Autowired
    private TrabajoRecolectarPtrPresenciaService trabajoRecolectarPtrPresenciaService;

    @Async
    @Override
    public CompletableFuture<Void> tiposHoras(final TrabajoDto trabajo,
            final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) {
        trabajoRecolectarPtrPresenciaService.tiposHoras(trabajo, runTrabajoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> presenciaTotalizadaTienda(final TrabajoDto trabajo,
            final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) {
        trabajoRecolectarPtrPresenciaService.presenciaTotalizadaTienda(trabajo, runTrabajoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> presenciaDetalleEmpleado(final TrabajoDto trabajo,
            final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) {
        trabajoRecolectarPtrPresenciaService.presenciaDetalleEmpleado(trabajo, runTrabajoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}