package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaSeccionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaSeccionVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;

@Service
public class TareaTiendaSeccionVentaAsyncServiceImpl implements TareaTiendaSeccionVentaAsyncService {

    @Autowired
    private TareaTiendaSeccionVentaService tareaTiendaSeccionVentaService;

    @Async
    @Override
    public CompletableFuture<Void> save(final PtrVentaTotalizadoResultItemDto item, final TareaDto tarea) {
        tareaTiendaSeccionVentaService.save(item, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> save(final List<PtrVentaTotalizadoResultItemDto> item, @Valid final TareaDto tarea)  {
        tareaTiendaSeccionVentaService.save(item, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
