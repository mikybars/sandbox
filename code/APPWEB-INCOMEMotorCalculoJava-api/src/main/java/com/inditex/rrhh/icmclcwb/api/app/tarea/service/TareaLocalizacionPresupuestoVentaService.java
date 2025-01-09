package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoVentaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaLocalizacionPresupuestoVentaService {

  List<TareaLocalizacionPresupuestoVentaDto> save(
      @Valid @NonNull @NotEmpty final List<TareaLocalizacionPresupuestoVentaDto> tareaLocalizacionPresupuestoVenta);

  List<TareaLocalizacionPresupuestoVentaDto> save(
      @Valid @NonNull @NotEmpty final List<VentaCongeladaResultItemDto> ventaCongelada,
      @Valid @NonNull final TareaDto tarea);

  List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaTotalizadoResponse(
      @Valid @NonNull final PtrVentaTotalizadoResponseDto dto,
      @Valid @NonNull final IdLocalizacionLocalPresupuestoDto iter,
      @Valid @NonNull final TareaDto tarea);

  List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaOnlineIpodResponse(
      @Valid @NonNull final PtrVentaOnlineIpodResponseDto dto,
      @Valid @NonNull final IdLocalizacionLocalPresupuestoDto iter,
      @Valid @NonNull final TareaDto tarea);

  List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaOnlinePickingResponse(
      @Valid @NonNull final PtrVentaOnlinePickingResponseDto dto,
      @Valid @NonNull final IdLocalizacionLocalPresupuestoDto iter, @Valid @NonNull final TareaDto tarea);

  List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaOnlineEntregaTiendaResponse(
      @Valid @NonNull final PtrVentaOnlineEntregaTiendaResponseDto dto,
      @Valid @NonNull final IdLocalizacionLocalPresupuestoDto iter, @Valid @NonNull final TareaDto tarea);

  List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaOnlineEntregaDomicilioResponse(
      @Valid @NonNull final PtrVentaOnlineEntregaDomicilioResponseDto dto,
      @Valid @NonNull final IdLocalizacionLocalPresupuestoDto iter, @Valid @NonNull final TareaDto tarea);

}
