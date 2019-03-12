package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaEmpleadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaEmpleadoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaRecolectarPtrVentaEmpleadoAsyncServiceImpl
        implements RunTareaRecolectarPtrVentaEmpleadoAsyncService {

    @Autowired
    private RunTareaRecolectarPtrVentaEmpleadoService tareaRecolectarPtrVentaEmpleadoService;

    @Async
    @Override
    public CompletableFuture<Void> ventaDetalleEmpleado(final RunTareaDto runTarea, final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarPtrVentaEmpleadoService.ventaDetalleEmpleado(runTarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
