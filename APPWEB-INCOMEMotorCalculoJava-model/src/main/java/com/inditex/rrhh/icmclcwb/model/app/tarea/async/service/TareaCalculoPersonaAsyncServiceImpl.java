package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaCalculoPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class TareaCalculoPersonaAsyncServiceImpl implements TareaCalculoPersonaAsyncService {

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;
    
    @Override
    public CompletableFuture<Void> mergePersonaCalculo(final RunTareaDto runTareaDto) {
        tareaCalculoPersonaService.mergePersonaCalculo(runTareaDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> updateWithEstado(final RunTareaDto runTareaDto, EstadoTareaPersonaDto estadoActual, EstadoTareaPersonaDto estadoNuevo) {
        tareaCalculoPersonaService.updateWithEstado(runTareaDto, estadoActual, estadoNuevo);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
