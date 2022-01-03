package com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;

import org.springframework.scheduling.annotation.Async;

@Async("ptrVentaExecutor")
public interface PtrVentaEcommerceAsyncService {

  CompletableFuture<PtrVentaOnlineIpodResponseDto> ventaOnlineiPod(PtrVentaOnlineIpodRequestDto request);

  CompletableFuture<PtrVentaOnlineIpodIndividualDetalleResponseDto> ventaOnlineiPodIndividualDetalle(
      PtrVentaOnlineIpodIndividualDetalleRequestDto request);

  CompletableFuture<PtrVentaOnlineEntregaDomicilioResponseDto> ventaOnlineEntregaDomicilio(
      PtrVentaOnlineEntregaDomicilioRequestDto request);

  CompletableFuture<PtrVentaOnlineEntregaTiendaResponseDto> ventaOnlineEntregaTienda(
      PtrVentaOnlineEntregaTiendaRequestDto request);

  CompletableFuture<PtrVentaOnlinePickingResponseDto> ventaOnlinePicking(PtrVentaOnlinePickingRequestDto request);

}
