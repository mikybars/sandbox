package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionVentaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionVentaSeccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

@Service
public class TareaLocalizacionVentaSeccionAsyncServiceImpl implements TareaLocalizacionVentaSeccionAsyncService {

    @Autowired
    private TareaLocalizacionVentaSeccionService tareaLocalizacionVentaSeccionService;

    @Override
    public CompletableFuture<Void> savePtrVentaTotalizadoResponse(final PtrVentaTotalizadoResponseDto dto,
            final TareaDto tarea) {
        tareaLocalizacionVentaSeccionService.savePtrVentaTotalizadoResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> savePtrVentaOnlineIpodResponse(final PtrVentaOnlineIpodResponseDto dto,
            final TareaDto tarea) {
        tareaLocalizacionVentaSeccionService.savePtrVentaOnlineIpodResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> savePtrVentaOnlineIpodIndividualDetalleResponse(
            final PtrVentaOnlineIpodIndividualDetalleResponseDto dto, final TareaDto tarea) {
        tareaLocalizacionVentaSeccionService.savePtrVentaOnlineIpodIndividualDetalleResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> savePtrVentaOnlinePickingResponse(final PtrVentaOnlinePickingResponseDto dto,
            final TareaDto tarea) {
        tareaLocalizacionVentaSeccionService.savePtrVentaOnlinePickingResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> savePtrVentaOnlineEntregaTiendaResponse(
            final PtrVentaOnlineEntregaTiendaResponseDto dto, final TareaDto tarea) {
        tareaLocalizacionVentaSeccionService.savePtrVentaOnlineEntregaTiendaResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> savePtrVentaOnlineEntregaDomicilioResponse(
            final PtrVentaOnlineEntregaDomicilioResponseDto dto, final TareaDto tarea) {
        tareaLocalizacionVentaSeccionService.savePtrVentaOnlineEntregaDomicilioResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
