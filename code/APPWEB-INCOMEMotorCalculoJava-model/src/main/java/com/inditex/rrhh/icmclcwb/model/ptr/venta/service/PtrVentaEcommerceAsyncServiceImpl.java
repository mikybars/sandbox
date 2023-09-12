package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaEcommerceAsyncService;
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
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaEcommerceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PtrVentaEcommerceAsyncServiceImpl implements PtrVentaEcommerceAsyncService {

  @Autowired
  private PtrVentaEcommerceService ptrVentaEcommerceService;

  @Override
  public CompletableFuture<PtrVentaOnlineEntregaDomicilioResponseDto> ventaOnlineEntregaDomicilio(
      final PtrVentaOnlineEntregaDomicilioRequestDto request) {
    return CompletableFuture.completedFuture(ptrVentaEcommerceService.ventaOnlineEntregaDomicilio(request));
  }

  @Override
  public CompletableFuture<PtrVentaOnlineEntregaTiendaResponseDto> ventaOnlineEntregaTienda(
      final PtrVentaOnlineEntregaTiendaRequestDto request) {
    return CompletableFuture.completedFuture(ptrVentaEcommerceService.ventaOnlineEntregaTienda(request));
  }

  @Override
  public CompletableFuture<PtrVentaOnlineIpodResponseDto> ventaOnlineiPod(
      final PtrVentaOnlineIpodRequestDto request) {
    return CompletableFuture.completedFuture(ptrVentaEcommerceService.ventaOnlineiPod(request));
  }

  @Override
  public CompletableFuture<PtrVentaOnlineIpodIndividualDetalleResponseDto> ventaOnlineiPodIndividualDetalle(
      final PtrVentaOnlineIpodIndividualDetalleRequestDto request) {
    return CompletableFuture.completedFuture(ptrVentaEcommerceService.ventaOnlineiPodIndividualDetalle(request));
  }

  @Override
  public CompletableFuture<PtrVentaOnlinePickingResponseDto> ventaOnlinePicking(
      final PtrVentaOnlinePickingRequestDto request) {
    return CompletableFuture.completedFuture(ptrVentaEcommerceService.ventaOnlinePicking(request));
  }

}
