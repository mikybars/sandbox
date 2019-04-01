package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

@Service
public class TareaTiendaVentaAsyncServiceImpl implements TareaTiendaVentaAsyncService {

    @Autowired
    private TareaTiendaVentaService tareaTiendaVentaService;
    
    
    @Override
    public CompletableFuture<Void> savePtrVentaTotalizadoResponse(final PtrVentaTotalizadoResponseDto dto, @Valid final TareaDto tarea)  {
        tareaTiendaVentaService.savePtrVentaTotalizadoResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    
    @Override
    public CompletableFuture<Void> savePtrVentaOnlineEntregaDomicilioResponse(final PtrVentaOnlineEntregaDomicilioResponseDto dto, @Valid final TareaDto tarea)  {
        tareaTiendaVentaService.savePtrVentaOnlineEntregaDomicilioResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    
    @Override
    public CompletableFuture<Void> savePtrVentaOnlineEntregaTiendaResponse(final PtrVentaOnlineEntregaTiendaResponseDto dto, @Valid final TareaDto tarea)  {
        tareaTiendaVentaService.savePtrVentaOnlineEntregaTiendaResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    
    @Override
    public CompletableFuture<Void> savePtrVentaOnlinePickingResponse(final PtrVentaOnlinePickingResponseDto dto, @Valid final TareaDto tarea)  {
        tareaTiendaVentaService.savePtrVentaOnlinePickingResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    
    @Override
    public CompletableFuture<Void> savePtrVentaOnlineIpodResponse(PtrVentaOnlineIpodResponseDto dto,
            @Valid TareaDto tarea) {
        tareaTiendaVentaService.savePtrVentaOnlineIpodResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    
    @Override
    public CompletableFuture<Void> savePtrVentaIndividualDetalleResponse(PtrVentaIndividualDetalleResponseDto dto,
            @Valid TareaDto tarea) {
        tareaTiendaVentaService.savePtrVentaIndividualDetalleResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
