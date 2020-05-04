package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaEmpleadoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaEmpleadoAsyncService;

import java.util.concurrent.CompletableFuture;

@Service
public class RunTareaRecolectarPtrVentaEmpleadoAsyncServiceImpl
        implements RunTareaRecolectarPtrVentaEmpleadoAsyncService {

    @Autowired
    private RunTareaRecolectarPtrVentaEmpleadoService tareaRecolectarPtrVentaEmpleadoService;

    @Override
    public CompletableFuture<Void> ventaOnlineIpodLocalizacionPersonaByRunTarea(RunTareaDto runTarea) {
        tareaRecolectarPtrVentaEmpleadoService.ventaFisicaLocalizacionPersonaByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
