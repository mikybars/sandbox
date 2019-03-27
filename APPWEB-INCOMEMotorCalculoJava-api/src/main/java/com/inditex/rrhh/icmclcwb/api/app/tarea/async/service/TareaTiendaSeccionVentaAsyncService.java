package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

public interface TareaTiendaSeccionVentaAsyncService {

	CompletableFuture<Void> savePtrVentaTotalizadoResponse(final PtrVentaTotalizadoResponseDto dto, @Valid final TareaDto tarea);

    CompletableFuture<Void> savePtrVentaOnlineEntregaDomicilioResponse(final PtrVentaOnlineEntregaDomicilioResponseDto dto,
            @Valid final TareaDto tarea);

    CompletableFuture<Void> savePtrVentaOnlineEntregaTiendaResponse(final PtrVentaOnlineEntregaTiendaResponseDto dto,
            @Valid final TareaDto tarea);

    CompletableFuture<Void> savePtrVentaOnlinePickingResponse(final PtrVentaOnlinePickingResponseDto dto,
            @Valid final TareaDto tarea);
    
    CompletableFuture<Void> savePtrVentaOnlineIpodResponse(final PtrVentaOnlineIpodResponseDto dto, @Valid final TareaDto tarea);


}
