package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoVentaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionPresupuestoVentaAsyncService {

  CompletableFuture<Void> save(List<TareaLocalizacionPresupuestoVentaDto> dto);

  CompletableFuture<Void> saveVentaCongeladaResultItemDto(List<VentaCongeladaResultItemDto> src, TareaDto tarea);

  CompletableFuture<Void> savePtrVentaTotalizadoResponse(PtrVentaTotalizadoResponseDto src,
      IdLocalizacionLocalPresupuestoDto iter, TareaDto tarea);

  CompletableFuture<Void> savePtrVentaOnlineIpodResponse(PtrVentaOnlineIpodResponseDto src,
      IdLocalizacionLocalPresupuestoDto iter, TareaDto tarea);

  CompletableFuture<Void> savePtrVentaOnlinePickingResponse(PtrVentaOnlinePickingResponseDto src,
      IdLocalizacionLocalPresupuestoDto iter, TareaDto tarea);

  CompletableFuture<Void> savePtrVentaOnlineEntregaTiendaResponse(PtrVentaOnlineEntregaTiendaResponseDto src,
      IdLocalizacionLocalPresupuestoDto iter, TareaDto tarea);

  CompletableFuture<Void> savePtrVentaOnlineEntregaDomicilioResponse(PtrVentaOnlineEntregaDomicilioResponseDto src,
      IdLocalizacionLocalPresupuestoDto iter, TareaDto tarea);

}
