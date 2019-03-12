package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaGeneralAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaGeneralService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaRecolectarPtrVentaGeneralAsyncServiceImpl implements RunTareaRecolectarPtrVentaGeneralAsyncService {

    @Autowired
    private RunTareaRecolectarPtrVentaGeneralService tareaRecolectarPtrVentaService;

    @Async
    @Override
    public CompletableFuture<Void> ventaTotalizadaTienda(final RunTareaDto runTarea, final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarPtrVentaService.ventaTotalizadaTienda(runTarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}