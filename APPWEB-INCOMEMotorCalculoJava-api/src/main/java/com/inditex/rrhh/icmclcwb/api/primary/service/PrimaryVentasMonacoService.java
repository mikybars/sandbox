package com.inditex.rrhh.icmclcwb.api.primary.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface PrimaryVentasMonacoService {

    void save(@Valid @NotNull @NotEmpty List<VentaManualWlocResultItemDto> src,
        @Valid @NotNull TareaDto tareaDto);

    List<TareaLocalizacionVentaDto> savePtrVentaTotalizadoResponse(
        @Valid @NotNull final PtrVentaTotalizadoResponseDto dto,
        @Valid @NotNull final TareaDto tarea);

    List<TareaLocalizacionVentaDto> savePtrVentaOnlineIpodResponse(
        @Valid @NotNull final PtrVentaOnlineIpodResponseDto dto,
        @Valid @NotNull final TareaDto tarea);

    List<TareaLocalizacionVentaDto> savePtrVentaOnlinePickingResponse(
        @Valid @NotNull final PtrVentaOnlinePickingResponseDto dto, @Valid @NotNull final TareaDto tarea);

    List<TareaLocalizacionVentaDto> savePtrVentaOnlineEntregaTiendaResponse(
        @Valid @NotNull final PtrVentaOnlineEntregaTiendaResponseDto dto, @Valid @NotNull final TareaDto tarea);

    List<TareaLocalizacionVentaDto> savePtrVentaTotalizadoResponseRepartoOnline(
        @Valid @NotNull final PtrVentaTotalizadoResponseDto dto,
        @Valid @NotNull final TareaDto tarea);

    void updateActivoVentaOnlineIpod(@Valid @NotNull final TareaDto tarea);

    void updateActivoVentaOnlinePicking(@Valid @NotNull final TareaDto tarea);

    void updateActivoVentaOnlineEntregaTienda(@Valid @NotNull final TareaDto tarea);

}
