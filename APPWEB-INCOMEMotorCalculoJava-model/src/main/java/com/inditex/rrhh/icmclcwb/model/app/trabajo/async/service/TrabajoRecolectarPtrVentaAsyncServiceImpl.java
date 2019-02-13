package com.inditex.rrhh.icmclcwb.model.app.trabajo.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoRecolectarPtrVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoRecolectarPtrVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class TrabajoRecolectarPtrVentaAsyncServiceImpl implements TrabajoRecolectarPtrVentaAsyncService {

    @Autowired
    private TrabajoRecolectarPtrVentaService trabajoRecolectarPtrVentaService;

    @Async
    @Override
    public CompletableFuture<Void> ventaTotalizadaTienda(final TrabajoDto trabajo, final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) {
        trabajoRecolectarPtrVentaService.ventaTotalizadaTienda(trabajo, runTrabajoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> ventaDetalleEmpleado(final TrabajoDto trabajo, final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) {
        trabajoRecolectarPtrVentaService.ventaDetalleEmpleado(trabajo, runTrabajoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}