package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoVentaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

public interface TareaLocalizacionPresupuestoVentaService {

    List<TareaLocalizacionPresupuestoVentaDto> save(
            @Valid List<TareaLocalizacionPresupuestoVentaDto> tareaLocalizacionPresupuestoVenta);

    List<TareaLocalizacionPresupuestoVentaDto> save(@Valid List<VentaCongeladaResultItemDto> ventaCongelada,
            TareaDto tarea);

    List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaTotalizadoResponse(@Valid PtrVentaTotalizadoResponseDto dto, @Valid IdLocalizacionLocalPresupuestoDto iter,
            @Valid TareaDto tarea);

    List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaOnlineIpodResponse(@Valid PtrVentaOnlineIpodResponseDto dto, @Valid IdLocalizacionLocalPresupuestoDto iter,
            @Valid TareaDto tarea);

    List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaOnlinePickingResponse(
            @Valid PtrVentaOnlinePickingResponseDto dto, @Valid IdLocalizacionLocalPresupuestoDto iter, @Valid TareaDto tarea);

    List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaOnlineEntregaTiendaResponse(
            @Valid PtrVentaOnlineEntregaTiendaResponseDto dto, @Valid IdLocalizacionLocalPresupuestoDto iter, @Valid TareaDto tarea);

    List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaOnlineEntregaDomicilioResponse(
            @Valid PtrVentaOnlineEntregaDomicilioResponseDto dto, @Valid IdLocalizacionLocalPresupuestoDto iter, @Valid TareaDto tarea);

}
