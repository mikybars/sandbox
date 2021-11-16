package com.inditex.rrhh.icmclcwb.api.ptr.venta.service;

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

import javax.validation.Valid;

public interface PtrVentaEcommerceService {

  PtrVentaOnlineIpodResponseDto ventaOnlineiPod(@Valid PtrVentaOnlineIpodRequestDto request);

  PtrVentaOnlineIpodIndividualDetalleResponseDto ventaOnlineiPodIndividualDetalle(
      @Valid PtrVentaOnlineIpodIndividualDetalleRequestDto request);

  PtrVentaOnlineEntregaDomicilioResponseDto ventaOnlineEntregaDomicilio(
      @Valid PtrVentaOnlineEntregaDomicilioRequestDto request);

  PtrVentaOnlineEntregaTiendaResponseDto ventaOnlineEntregaTienda(
      @Valid PtrVentaOnlineEntregaTiendaRequestDto request);

  PtrVentaOnlinePickingResponseDto ventaOnlinePicking(@Valid PtrVentaOnlinePickingRequestDto request);

}
