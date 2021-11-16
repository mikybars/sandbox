package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

import javax.validation.constraints.NotNull;
import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionVentaAsyncService {

  CompletableFuture<Void> savePtrVentaTotalizadoResponse(PtrVentaTotalizadoResponseDto dto, TareaDto tarea);

  CompletableFuture<Void> savePtrVentaTotalizadoResponseRepartoOnline(PtrVentaTotalizadoResponseDto dto,
      TareaDto tarea);

  CompletableFuture<Void> savePtrVentaOnlineIpodResponse(PtrVentaOnlineIpodResponseDto dto, TareaDto tarea);

  CompletableFuture<Void> savePtrVentaOnlinePickingResponse(PtrVentaOnlinePickingResponseDto dto, TareaDto tarea);

  CompletableFuture<Void> savePtrVentaOnlineEntregaTiendaResponse(PtrVentaOnlineEntregaTiendaResponseDto dto,
      TareaDto tarea);

  CompletableFuture<Void> savePtrVentaOnlineEntregaDomicilioResponse(PtrVentaOnlineEntregaDomicilioResponseDto dto,
      TareaDto tarea);

  CompletableFuture<Void> save(@NotNull List<VentaManualWlocResultItemDto> src, @NotNull TareaDto tareaDto);

}
