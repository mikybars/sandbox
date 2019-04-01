package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaSeccionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaSeccionVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

@Service
public class TareaTiendaSeccionVentaAsyncServiceImpl implements TareaTiendaSeccionVentaAsyncService {

    @Autowired
    private TareaTiendaSeccionVentaService tareaTiendaSeccionVentaService;

    
    @Override
    public CompletableFuture<Void> savePtrVentaTotalizadoResponse(final PtrVentaTotalizadoResponseDto dto,final TareaDto tarea)  {
        tareaTiendaSeccionVentaService.savePtrVentaTotalizadoResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    
    @Override
    public CompletableFuture<Void> savePtrVentaOnlineEntregaDomicilioResponse(final PtrVentaOnlineEntregaDomicilioResponseDto dto,final TareaDto tarea)  {
        tareaTiendaSeccionVentaService.savePtrVentaOnlineEntregaDomicilioResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    
    @Override
    public CompletableFuture<Void> savePtrVentaOnlineEntregaTiendaResponse(final PtrVentaOnlineEntregaTiendaResponseDto dto,final TareaDto tarea)  {
        tareaTiendaSeccionVentaService.savePtrVentaOnlineEntregaTiendaResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    
    @Override
    public CompletableFuture<Void> savePtrVentaOnlinePickingResponse(final PtrVentaOnlinePickingResponseDto dto,final TareaDto tarea)  {
        tareaTiendaSeccionVentaService.savePtrVentaOnlinePickingResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    
    @Override
    public CompletableFuture<Void> savePtrVentaOnlineIpodResponse(PtrVentaOnlineIpodResponseDto dto,
           TareaDto tarea) {
        tareaTiendaSeccionVentaService.savePtrVentaOnlineIpodResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    

}
