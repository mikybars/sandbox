package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaPresenciaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaPresenciaSeccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
@Validated
public class TareaTiendaPresenciaSeccionAsyncServiceImpl implements TareaTiendaPresenciaSeccionAsyncService {

    @Autowired
    private TareaTiendaPresenciaSeccionService tareaTiendaPresenciaSeccionService;
    
    @Async
    @Override
    public CompletableFuture<Void> pivot(@Valid final TareaDto tarea)  {
        tareaTiendaPresenciaSeccionService.pivot(tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
