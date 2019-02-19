package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaRecolectarPtrVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaRecolectarPtrVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class TareaRecolectarPtrVentaAsyncServiceImpl implements TareaRecolectarPtrVentaAsyncService {

    @Autowired
    private TareaRecolectarPtrVentaService tareaRecolectarPtrVentaService;

    @Async
    @Override
    public CompletableFuture<Void> ventaTotalizadaTienda(final TareaDto tarea, final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarPtrVentaService.ventaTotalizadaTienda(tarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> ventaDetalleEmpleado(final TareaDto tarea, final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarPtrVentaService.ventaDetalleEmpleado(tarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}