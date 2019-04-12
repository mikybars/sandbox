package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaVentaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

public interface TareaTiendaVentaSeccionService {

    @Deprecated
    void pivot(@Valid final TareaDto tarea);

    List<TareaTiendaVentaSeccionDto> savePtrVentaTotalizadoResponse(@Valid final PtrVentaTotalizadoResponseDto dto, @Valid final TareaDto tarea);

    List<TareaTiendaVentaSeccionDto> savePtrVentaOnlineIpodResponse(@Valid final PtrVentaOnlineIpodResponseDto dto, @Valid final TareaDto tarea);

    List<TareaTiendaVentaSeccionDto> savePtrVentaOnlineIpodIndividualDetalleResponse(
            @Valid final PtrVentaOnlineIpodIndividualDetalleResponseDto dto, @Valid final TareaDto tarea);

    List<TareaTiendaVentaSeccionDto> savePtrVentaOnlinePickingResponse(@Valid final PtrVentaOnlinePickingResponseDto dto,
            @Valid final TareaDto tarea);

    List<TareaTiendaVentaSeccionDto> savePtrVentaOnlineEntregaTiendaResponse(@Valid final PtrVentaOnlineEntregaTiendaResponseDto dto,
            @Valid final TareaDto tarea);

    List<TareaTiendaVentaSeccionDto> savePtrVentaOnlineEntregaDomicilioResponse(
            @Valid final PtrVentaOnlineEntregaDomicilioResponseDto dto, @Valid final TareaDto tarea);

}
