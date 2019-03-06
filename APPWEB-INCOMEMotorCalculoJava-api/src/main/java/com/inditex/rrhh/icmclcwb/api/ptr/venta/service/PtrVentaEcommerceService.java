package com.inditex.rrhh.icmclcwb.api.ptr.venta.service;

import javax.validation.Valid;

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
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountryhour.dto.PtrVentaOrdersByCountryHourRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountryhour.dto.PtrVentaOrdersByCountryHourResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountryminute.dto.PtrVentaOrdersByCountryMinuteRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountryminute.dto.PtrVentaOrdersByCountryMinuteResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproducthour.dto.PtrVentaOrdersByCountrySectionProductHourRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproducthour.dto.PtrVentaOrdersByCountrySectionProductHourResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproductminute.dto.PtrVentaOrdersByCountrySectionProductMinuteRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproductminute.dto.PtrVentaOrdersByCountrySectionProductMinuteResponseDto;

public interface PtrVentaEcommerceService {

    PtrVentaOnlineIpodResponseDto ventaOnlineiPod(@Valid PtrVentaOnlineIpodRequestDto request);
    
    PtrVentaOnlineIpodIndividualDetalleResponseDto ventaOnlineiPodIndividualDetalle(
            @Valid PtrVentaOnlineIpodIndividualDetalleRequestDto request);

    PtrVentaOnlineEntregaDomicilioResponseDto ventaOnlineEntregaDomicilio(
            @Valid PtrVentaOnlineEntregaDomicilioRequestDto request);

    PtrVentaOnlineEntregaTiendaResponseDto ventaOnlineEntregaTienda(
            @Valid PtrVentaOnlineEntregaTiendaRequestDto request);

    PtrVentaOnlinePickingResponseDto ventaOnlinePicking(@Valid PtrVentaOnlinePickingRequestDto request);

    PtrVentaOrdersByCountryHourResponseDto ordersByCountryHour(@Valid PtrVentaOrdersByCountryHourRequestDto request);

    PtrVentaOrdersByCountrySectionProductHourResponseDto ordersByCountrySectionProductHour(
            @Valid PtrVentaOrdersByCountrySectionProductHourRequestDto request);
    
    PtrVentaOrdersByCountrySectionProductMinuteResponseDto ordersByCountrySectionProductMinute(
            @Valid PtrVentaOrdersByCountrySectionProductMinuteRequestDto request);

    PtrVentaOrdersByCountryMinuteResponseDto ordersByCountryMinute(
            @Valid PtrVentaOrdersByCountryMinuteRequestDto request);

    String version();

    String test();

}
