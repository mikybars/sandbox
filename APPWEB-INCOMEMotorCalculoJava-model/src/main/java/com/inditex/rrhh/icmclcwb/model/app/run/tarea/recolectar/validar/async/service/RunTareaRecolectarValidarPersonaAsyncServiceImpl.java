package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.validar.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service.RunTareaRecolectarValidarPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaRecolectarValidarPersonaAsyncServiceImpl implements RunTareaRecolectarValidarPersonaAsyncService {

    @Autowired
    private RunTareaRecolectarValidarPersonaService runTareaRecolectarValidarPersonaService;
    
    
    @Override
    public CompletableFuture<Void> run(@NotNull @Valid RunTareaDto runTarea) {
        runTareaRecolectarValidarPersonaService.run(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
