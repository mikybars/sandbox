package com.inditex.rrhh.icmclcwb.model.app.proceso.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoRecolectarPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class ProcesoRecolectarPtrPresenciaAsyncServiceImpl implements ProcesoRecolectarPtrPresenciaAsyncService {

    @Autowired
    private ProcesoRecolectarPtrPresenciaService procesoRecolectarPtrPresenciaService;

    @Async
    @Override
    public CompletableFuture<Void> tiposHoras(final ProcesoDto proceso,
            final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        procesoRecolectarPtrPresenciaService.tiposHoras(proceso, runProcesoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> presenciaTotalizadaTienda(final ProcesoDto proceso,
            final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        procesoRecolectarPtrPresenciaService.presenciaTotalizadaTienda(proceso, runProcesoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> presenciaDetalleEmpleado(final ProcesoDto proceso,
            final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        procesoRecolectarPtrPresenciaService.presenciaDetalleEmpleado(proceso, runProcesoRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}