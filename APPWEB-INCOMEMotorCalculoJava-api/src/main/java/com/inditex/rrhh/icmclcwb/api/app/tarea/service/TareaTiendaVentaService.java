package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaVentaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

public interface TareaTiendaVentaService {

    List<TareaTiendaVentaDto> savePtrVentaTotalizadoResponse(@Valid final PtrVentaTotalizadoResponseDto dto, @Valid final TareaDto tarea);

    List<TareaTiendaVentaDto> savePtrVentaOnlineEntregaDomicilioResponse(
            @Valid final PtrVentaOnlineEntregaDomicilioResponseDto dto, @Valid final TareaDto tarea);

    List<TareaTiendaVentaDto> savePtrVentaOnlineEntregaTiendaResponse(@Valid final PtrVentaOnlineEntregaTiendaResponseDto dto,
            @Valid final TareaDto tarea);

    List<TareaTiendaVentaDto> savePtrVentaOnlinePickingResponse(@Valid final PtrVentaOnlinePickingResponseDto dto,
            @Valid final TareaDto tarea);

    List<TareaTiendaVentaDto> savePtrVentaOnlineIpodResponse(@Valid final PtrVentaOnlineIpodResponseDto dto, @Valid final TareaDto tarea);

    List<TareaTiendaVentaDto> savePtrVentaIndividualDetalleResponse(@Valid final PtrVentaIndividualDetalleResponseDto dto,
            @Valid final TareaDto tarea);

}
