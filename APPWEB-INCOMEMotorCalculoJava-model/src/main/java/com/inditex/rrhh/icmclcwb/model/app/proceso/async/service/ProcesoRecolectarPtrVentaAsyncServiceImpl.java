package com.inditex.rrhh.icmclcwb.model.app.proceso.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoRecolectarPtrVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoRecolectarPtrVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class ProcesoRecolectarPtrVentaAsyncServiceImpl implements ProcesoRecolectarPtrVentaAsyncService {

    @Autowired
    private ProcesoRecolectarPtrVentaService procesoRecolectarPtrVentaService;

    @Async
    @Override
    public CompletableFuture<Void> ventaTotalizadaTienda(final ProcesoDto proceso, final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        procesoRecolectarPtrVentaService.ventaTotalizadaTienda(proceso, runProcesoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> ventaDetalleEmpleado(final ProcesoDto proceso, final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        procesoRecolectarPtrVentaService.ventaDetalleEmpleado(proceso, runProcesoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}