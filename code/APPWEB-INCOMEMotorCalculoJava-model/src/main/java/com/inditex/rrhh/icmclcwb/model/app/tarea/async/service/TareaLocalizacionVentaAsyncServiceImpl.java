package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaLocalizacionVentaAsyncServiceImpl implements TareaLocalizacionVentaAsyncService {

  @Autowired
  private TareaLocalizacionVentaService tareaLocalizacionVentaService;

  @Override
  public CompletableFuture<Void> save(@NonNull final List<VentaManualWlocResultItemDto> src,
      @NonNull final TareaDto tareaDto) {
    this.tareaLocalizacionVentaService.save(src, tareaDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> savePtrVentaTotalizadoResponse(final PtrVentaTotalizadoResponseDto dto,
      final TareaDto tarea) {
    this.tareaLocalizacionVentaService.savePtrVentaTotalizadoResponse(dto, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> savePtrVentaTotalizadoResponseRepartoOnline(
      final PtrVentaTotalizadoResponseDto dto, final TareaDto tarea) {
    this.tareaLocalizacionVentaService.savePtrVentaTotalizadoResponseRepartoOnline(dto, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> savePtrVentaOnlineIpodResponse(final PtrVentaOnlineIpodResponseDto dto,
      final TareaDto tarea) {
    this.tareaLocalizacionVentaService.savePtrVentaOnlineIpodResponse(dto, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> savePtrVentaOnlinePickingResponse(final PtrVentaOnlinePickingResponseDto dto,
      final TareaDto tarea) {
    this.tareaLocalizacionVentaService.savePtrVentaOnlinePickingResponse(dto, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> savePtrVentaOnlineEntregaTiendaResponse(
      final PtrVentaOnlineEntregaTiendaResponseDto dto,
      final TareaDto tarea) {
    this.tareaLocalizacionVentaService.savePtrVentaOnlineEntregaTiendaResponse(dto, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> savePtrVentaOnlineEntregaDomicilioResponse(
      final PtrVentaOnlineEntregaDomicilioResponseDto dto, final TareaDto tarea) {
    this.tareaLocalizacionVentaService.savePtrVentaOnlineEntregaDomicilioResponse(dto, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
