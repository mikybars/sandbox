package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaLocalizacionVentaService {

  List<TareaLocalizacionVentaDto> savePtrVentaTotalizadoResponse(
      @Valid @NonNull final PtrVentaTotalizadoResponseDto dto,
      @Valid @NonNull final TareaDto tarea);

  List<TareaLocalizacionVentaDto> savePtrVentaTotalizadoResponseRepartoOnline(
      @Valid @NonNull final PtrVentaTotalizadoResponseDto dto,
      @Valid @NonNull final TareaDto tarea);

  List<TareaLocalizacionVentaDto> savePtrVentaOnlineIpodResponse(
      @Valid @NonNull final PtrVentaOnlineIpodResponseDto dto,
      @Valid @NonNull final TareaDto tarea);

  List<TareaLocalizacionVentaDto> savePtrVentaOnlinePickingResponse(
      @Valid @NonNull final PtrVentaOnlinePickingResponseDto dto, @Valid @NonNull final TareaDto tarea);

  List<TareaLocalizacionVentaDto> savePtrVentaOnlineEntregaTiendaResponse(
      @Valid @NonNull final PtrVentaOnlineEntregaTiendaResponseDto dto, @Valid @NonNull final TareaDto tarea);

  List<TareaLocalizacionVentaDto> savePtrVentaOnlineEntregaDomicilioResponse(
      @Valid @NonNull final PtrVentaOnlineEntregaDomicilioResponseDto dto, @Valid @NonNull final TareaDto tarea);

  void updateActivoVentaOnlineIpod(@Valid @NonNull final TareaDto tarea);

  void updateActivoVentaOnlinePicking(@Valid @NonNull final TareaDto tarea);

  void updateActivoVentaOnlineEntregaTienda(@Valid @NonNull final TareaDto tarea);

  void save(@Valid @NonNull @NotEmpty List<VentaManualWlocResultItemDto> src,
      @Valid @NonNull TareaDto tareaDto);

}
