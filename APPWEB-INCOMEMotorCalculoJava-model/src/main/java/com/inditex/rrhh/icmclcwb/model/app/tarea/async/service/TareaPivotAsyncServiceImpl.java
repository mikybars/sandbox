package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPivotAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaPresenciaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaVentaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
@Validated
public class TareaPivotAsyncServiceImpl implements TareaPivotAsyncService {

    @Autowired
    private TareaTiendaPresenciaSeccionAsyncService tareaTiendaPresenciaSeccionAsyncService;
    
    @Autowired
    private TareaTiendaVentaSeccionAsyncService tareaTiendaVentaSeccionAsyncService;
    
    @Async
    @Override
    public CompletableFuture<Void> pivot(@Valid final TareaDto tarea) {
        tareaTiendaPresenciaSeccionAsyncService.pivot(tarea);
        tareaTiendaVentaSeccionAsyncService.pivot(tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
