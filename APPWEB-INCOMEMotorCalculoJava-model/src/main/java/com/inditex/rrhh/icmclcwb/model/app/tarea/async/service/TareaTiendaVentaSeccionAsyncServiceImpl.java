package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaVentaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaVentaSeccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class TareaTiendaVentaSeccionAsyncServiceImpl implements TareaTiendaVentaSeccionAsyncService {

    @Autowired
    private TareaTiendaVentaSeccionService tareaTiendaVentaSeccionService;
    
    @Async
    @Override
    public CompletableFuture<Void> pivot(final TareaDto tarea)  {
        tareaTiendaVentaSeccionService.pivot(tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
}
