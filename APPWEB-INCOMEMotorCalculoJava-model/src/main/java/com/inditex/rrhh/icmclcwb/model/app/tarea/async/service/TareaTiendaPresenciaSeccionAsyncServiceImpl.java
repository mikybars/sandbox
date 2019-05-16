package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaPresenciaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaPresenciaSeccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;

@Service
public class TareaTiendaPresenciaSeccionAsyncServiceImpl implements TareaTiendaPresenciaSeccionAsyncService {

    @Autowired
    private TareaTiendaPresenciaSeccionService tareaTiendaPresenciaSeccionService;

    @Override
    public CompletableFuture<Void> save(List<PtrPresenciaTotalizadoResultItemDto> dto, TareaDto tarea) {
        tareaTiendaPresenciaSeccionService.save(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> compensar(@Valid final RunTareaDto runTarea) {
        tareaTiendaPresenciaSeccionService.compensar(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
