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
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountryhour.dto.PtrVentaOrdersByCountryHourRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountryhour.dto.PtrVentaOrdersByCountryHourResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountryminute.dto.PtrVentaOrdersByCountryMinuteRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountryminute.dto.PtrVentaOrdersByCountryMinuteResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproducthour.dto.PtrVentaOrdersByCountrySectionProductHourRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproducthour.dto.PtrVentaOrdersByCountrySectionProductHourResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproductminute.dto.PtrVentaOrdersByCountrySectionProductMinuteRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproductminute.dto.PtrVentaOrdersByCountrySectionProductMinuteResponseDto;

public interface PtrVentaEcommerceAsyncService {

    CompletableFuture<String> test();
    
    CompletableFuture<String> getVersion();

    CompletableFuture<PtrVentaOnlineIpodResponseDto> ventaOnlineiPod(PtrVentaOnlineIpodRequestDto request);

    CompletableFuture<PtrVentaOnlineIpodIndividualDetalleResponseDto> ventaOnlineiPodIndividualDetalle(
            PtrVentaOnlineIpodIndividualDetalleRequestDto request);

    CompletableFuture<PtrVentaOnlineEntregaDomicilioResponseDto> ventaOnlineEntregaDomicilio(
            PtrVentaOnlineEntregaDomicilioRequestDto request);

    CompletableFuture<PtrVentaOnlineEntregaTiendaResponseDto> ventaOnlineEntregaTienda(
            PtrVentaOnlineEntregaTiendaRequestDto request);

    CompletableFuture<PtrVentaOnlinePickingResponseDto> ventaOnlinePicking(PtrVentaOnlinePickingRequestDto request);

    CompletableFuture<PtrVentaOrdersByCountryHourResponseDto> ordersByCountryHour(
            PtrVentaOrdersByCountryHourRequestDto request);

    CompletableFuture<PtrVentaOrdersByCountrySectionProductHourResponseDto> ordersByCountrySectionProductHour(
            PtrVentaOrdersByCountrySectionProductHourRequestDto request);

    CompletableFuture<PtrVentaOrdersByCountrySectionProductMinuteResponseDto> ordersByCountrySectionProductMinute(
            PtrVentaOrdersByCountrySectionProductMinuteRequestDto request);

    CompletableFuture<PtrVentaOrdersByCountryMinuteResponseDto> ordersByCountryHour(
            PtrVentaOrdersByCountryMinuteRequestDto request);

}
