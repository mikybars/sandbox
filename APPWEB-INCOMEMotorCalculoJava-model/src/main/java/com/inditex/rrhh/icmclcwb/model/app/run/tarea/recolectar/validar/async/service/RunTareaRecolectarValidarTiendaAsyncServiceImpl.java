package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.validar.async.service;

import java.util.concurrent.CompletableFuture;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarTiendaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service.RunTareaRecolectarValidarTiendaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaRecolectarValidarTiendaAsyncServiceImpl implements RunTareaRecolectarValidarTiendaAsyncService {

    @Autowired
    private RunTareaRecolectarValidarTiendaService runTareaRecolectarValidarTiendaService;
    
    
    @Override
    public CompletableFuture<Void> run(RunTareaDto runTarea) {
        runTareaRecolectarValidarTiendaService.run(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
