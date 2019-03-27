package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaVentaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaVentaSeccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

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
    
    @Async
    @Override
    public CompletableFuture<Void> savePtrVentaTotalizadoResponse(final PtrVentaTotalizadoResponseDto dto, @Valid final TareaDto tarea)  {
        tareaTiendaVentaSeccionService.savePtrVentaTotalizadoResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Async
    @Override
    public CompletableFuture<Void> savePtrVentaOnlineIpodResponse(final PtrVentaOnlineIpodResponseDto dto, @Valid final TareaDto tarea)  {
        tareaTiendaVentaSeccionService.savePtrVentaOnlineIpodResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Async
    @Override
    public CompletableFuture<Void> savePtrVentaOnlineIpodIndividualDetalleResponse(final PtrVentaOnlineIpodIndividualDetalleResponseDto dto, @Valid final TareaDto tarea)  {
        tareaTiendaVentaSeccionService.savePtrVentaOnlineIpodIndividualDetalleResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Async
    @Override
    public CompletableFuture<Void> savePtrVentaOnlinePickingResponse(final PtrVentaOnlinePickingResponseDto dto, @Valid final TareaDto tarea)  {
        tareaTiendaVentaSeccionService.savePtrVentaOnlinePickingResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Async
    @Override
    public CompletableFuture<Void> savePtrVentaOnlineEntregaTiendaResponse(final PtrVentaOnlineEntregaTiendaResponseDto dto, @Valid final TareaDto tarea)  {
        tareaTiendaVentaSeccionService.savePtrVentaOnlineEntregaTiendaResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Async
    @Override
    public CompletableFuture<Void> savePtrVentaOnlineEntregaDomicilioResponse(final PtrVentaOnlineEntregaDomicilioResponseDto dto, @Valid final TareaDto tarea)  {
        tareaTiendaVentaSeccionService.savePtrVentaOnlineEntregaDomicilioResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
}
