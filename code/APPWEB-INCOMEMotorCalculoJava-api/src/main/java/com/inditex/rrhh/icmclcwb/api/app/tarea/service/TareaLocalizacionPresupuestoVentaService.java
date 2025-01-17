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
import jakarta.validation.constraints.NotNull;

public interface TareaLocalizacionPresupuestoVentaService {

  List<TareaLocalizacionPresupuestoVentaDto> save(
      @Valid @NotNull @NotEmpty final List<TareaLocalizacionPresupuestoVentaDto> tareaLocalizacionPresupuestoVenta);

  List<TareaLocalizacionPresupuestoVentaDto> save(
      @Valid @NotNull @NotEmpty final List<VentaCongeladaResultItemDto> ventaCongelada,
      @Valid @NotNull final TareaDto tarea);

  List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaTotalizadoResponse(
      @Valid @NotNull final PtrVentaTotalizadoResponseDto dto,
      @Valid @NotNull final IdLocalizacionLocalPresupuestoDto iter,
      @Valid @NotNull final TareaDto tarea);

  List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaOnlineIpodResponse(
      @Valid @NotNull final PtrVentaOnlineIpodResponseDto dto,
      @Valid @NotNull final IdLocalizacionLocalPresupuestoDto iter,
      @Valid @NotNull final TareaDto tarea);

  List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaOnlinePickingResponse(
      @Valid @NotNull final PtrVentaOnlinePickingResponseDto dto,
      @Valid @NotNull final IdLocalizacionLocalPresupuestoDto iter, @Valid @NotNull final TareaDto tarea);

  List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaOnlineEntregaTiendaResponse(
      @Valid @NotNull final PtrVentaOnlineEntregaTiendaResponseDto dto,
      @Valid @NotNull final IdLocalizacionLocalPresupuestoDto iter, @Valid @NotNull final TareaDto tarea);

  List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaOnlineEntregaDomicilioResponse(
      @Valid @NotNull final PtrVentaOnlineEntregaDomicilioResponseDto dto,
      @Valid @NotNull final IdLocalizacionLocalPresupuestoDto iter, @Valid @NotNull final TareaDto tarea);

}
