package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

@Service
public class TareaLocalizacionVentaAsyncServiceImpl implements TareaLocalizacionVentaAsyncService {

    @Autowired
    private TareaLocalizacionVentaService tareaLocalizacionVentaService;
    
    @Override
    public CompletableFuture<Void> savePtrVentaTotalizadoResponse(final PtrVentaTotalizadoResponseDto dto,final TareaDto tarea)  {
        tareaLocalizacionVentaService.savePtrVentaTotalizadoResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    
    @Override
    public CompletableFuture<Void> savePtrVentaOnlineEntregaDomicilioResponse(final PtrVentaOnlineEntregaDomicilioResponseDto dto,final TareaDto tarea)  {
        tareaLocalizacionVentaService.savePtrVentaOnlineEntregaDomicilioResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    
    @Override
    public CompletableFuture<Void> savePtrVentaOnlineEntregaTiendaResponse(final PtrVentaOnlineEntregaTiendaResponseDto dto,final TareaDto tarea)  {
        tareaLocalizacionVentaService.savePtrVentaOnlineEntregaTiendaResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    
    @Override
    public CompletableFuture<Void> savePtrVentaOnlinePickingResponse(final PtrVentaOnlinePickingResponseDto dto,final TareaDto tarea)  {
        tareaLocalizacionVentaService.savePtrVentaOnlinePickingResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    
    @Override
    public CompletableFuture<Void> savePtrVentaOnlineIpodResponse(PtrVentaOnlineIpodResponseDto dto,
           TareaDto tarea) {
        tareaLocalizacionVentaService.savePtrVentaOnlineIpodResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    
    @Override
    public CompletableFuture<Void> savePtrVentaIndividualDetalleResponse(PtrVentaIndividualDetalleResponseDto dto,
           TareaDto tarea) {
        tareaLocalizacionVentaService.savePtrVentaIndividualDetalleResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
