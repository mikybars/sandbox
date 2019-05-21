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
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

@Service
public class TareaTiendaSeccionVentaAsyncServiceImpl implements TareaTiendaSeccionVentaAsyncService {

    @Autowired
    private TareaTiendaSeccionVentaService tareaTiendaSeccionVentaService;
    
    @Override
    public CompletableFuture<Void> savePtrVentaTotalizadoResponse(PtrVentaTotalizadoResponseDto dto, TareaDto tarea) {
        tareaTiendaSeccionVentaService.savePtrVentaTotalizadoResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> savePtrVentaOnlineIpodResponse(PtrVentaOnlineIpodResponseDto dto, TareaDto tarea) {
        tareaTiendaSeccionVentaService.savePtrVentaOnlineIpodResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> savePtrVentaOnlineIpodIndividualDetalleResponse(
            PtrVentaOnlineIpodIndividualDetalleResponseDto dto, TareaDto tarea) {
        tareaTiendaSeccionVentaService.savePtrVentaOnlineIpodIndividualDetalleResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> savePtrVentaOnlinePickingResponse(PtrVentaOnlinePickingResponseDto dto,
            TareaDto tarea) {
        tareaTiendaSeccionVentaService.savePtrVentaOnlinePickingResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> savePtrVentaOnlineEntregaTiendaResponse(PtrVentaOnlineEntregaTiendaResponseDto dto,
            TareaDto tarea) {
        tareaTiendaSeccionVentaService.savePtrVentaOnlineEntregaTiendaResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> savePtrVentaOnlineEntregaDomicilioResponse(
            PtrVentaOnlineEntregaDomicilioResponseDto dto, TareaDto tarea) {
        tareaTiendaSeccionVentaService.savePtrVentaOnlineEntregaDomicilioResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
