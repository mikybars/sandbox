package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

public interface TareaTiendaSeccionVentaService {

    List<TareaTiendaSeccionVentaDto> savePtrVentaTotalizadoResponse(final PtrVentaTotalizadoResponseDto dto, final TareaDto tarea);

    List<TareaTiendaSeccionVentaDto> savePtrVentaOnlineEntregaDomicilioResponse(
            final PtrVentaOnlineEntregaDomicilioResponseDto dto, final TareaDto tarea);

    List<TareaTiendaSeccionVentaDto> savePtrVentaOnlineEntregaTiendaResponse(final PtrVentaOnlineEntregaTiendaResponseDto dto,
            final TareaDto tarea);

    List<TareaTiendaSeccionVentaDto> savePtrVentaOnlinePickingResponse(final PtrVentaOnlinePickingResponseDto dto,
            final TareaDto tarea);

    List<TareaTiendaSeccionVentaDto> savePtrVentaOnlineIpodResponse(final PtrVentaOnlineIpodResponseDto dto, final TareaDto tarea);

}
