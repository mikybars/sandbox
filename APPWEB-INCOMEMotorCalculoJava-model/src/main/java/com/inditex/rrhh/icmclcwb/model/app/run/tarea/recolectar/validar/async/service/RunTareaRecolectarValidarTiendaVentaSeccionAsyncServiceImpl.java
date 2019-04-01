package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.validar.async.service;

import java.util.concurrent.CompletableFuture;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarTiendaVentaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service.RunTareaRecolectarValidarTiendaVentaSeccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaRecolectarValidarTiendaVentaSeccionAsyncServiceImpl
        implements RunTareaRecolectarValidarTiendaVentaSeccionAsyncService {

    @Autowired
    private RunTareaRecolectarValidarTiendaVentaSeccionService runTareaRecolectarValidarTiendaVentaSeccionService;
    
    
    @Override
    public CompletableFuture<Void> run(RunTareaDto runTarea) {
        runTareaRecolectarValidarTiendaVentaSeccionService.run(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
