package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

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
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountryhour.dto.PtrVentaOrdersByCountryHourRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountryhour.dto.PtrVentaOrdersByCountryHourResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountryminute.dto.PtrVentaOrdersByCountryMinuteRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountryminute.dto.PtrVentaOrdersByCountryMinuteResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproducthour.dto.PtrVentaOrdersByCountrySectionProductHourRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproducthour.dto.PtrVentaOrdersByCountrySectionProductHourResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproductminute.dto.PtrVentaOrdersByCountrySectionProductMinuteRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproductminute.dto.PtrVentaOrdersByCountrySectionProductMinuteResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaEcommerceService;

@Service
public class PtrVentaEcommerceAsyncServiceImpl implements PtrVentaEcommerceAsyncService {
    
    @Autowired
    private PtrVentaEcommerceService ptrVentaEcommerceService;
    
    @Async
    @Override
    public CompletableFuture<PtrVentaOnlineEntregaDomicilioResponseDto> ventaOnlineEntregaDomicilio(
            final PtrVentaOnlineEntregaDomicilioRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaEcommerceService.ventaOnlineEntregaDomicilio(request));
    }
    
    @Async
    @Override
    public CompletableFuture<PtrVentaOnlineEntregaTiendaResponseDto> ventaOnlineEntregaTienda(
            final PtrVentaOnlineEntregaTiendaRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaEcommerceService.ventaOnlineEntregaTienda(request));
    }
    
    @Async
    @Override
    public CompletableFuture<PtrVentaOnlineIpodResponseDto> ventaOnlineiPod(
            final PtrVentaOnlineIpodRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaEcommerceService.ventaOnlineiPod(request));
    }
    
    @Async
    @Override
    public CompletableFuture<PtrVentaOnlineIpodIndividualDetalleResponseDto> ventaOnlineiPodIndividualDetalle(
            final PtrVentaOnlineIpodIndividualDetalleRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaEcommerceService.ventaOnlineiPodIndividualDetalle(request));
    }
    
    @Async
    @Override
    public CompletableFuture<PtrVentaOnlinePickingResponseDto> ventaOnlinePicking(
            final PtrVentaOnlinePickingRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaEcommerceService.ventaOnlinePicking(request));
    }
    
    @Async
    @Override
    public CompletableFuture<PtrVentaOrdersByCountryHourResponseDto> ordersByCountryHour(
            final PtrVentaOrdersByCountryHourRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaEcommerceService.ordersByCountryHour(request));
    }
    
    @Async
    @Override
    public CompletableFuture<PtrVentaOrdersByCountryMinuteResponseDto> ordersByCountryHour(
            final PtrVentaOrdersByCountryMinuteRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaEcommerceService.ordersByCountryMinute(request));
    }
    
    @Async
    @Override
    public CompletableFuture<PtrVentaOrdersByCountrySectionProductHourResponseDto> ordersByCountrySectionProductHour(
            final PtrVentaOrdersByCountrySectionProductHourRequestDto request) { 
        return CompletableFuture.completedFuture(ptrVentaEcommerceService.ordersByCountrySectionProductHour(request));
    }
    
    @Async
    @Override
    public CompletableFuture<PtrVentaOrdersByCountrySectionProductMinuteResponseDto> ordersByCountrySectionProductMinute(
            final PtrVentaOrdersByCountrySectionProductMinuteRequestDto request) { 
        return CompletableFuture.completedFuture(ptrVentaEcommerceService.ordersByCountrySectionProductMinute(request));
    }

    @Async
    @Override 
    public CompletableFuture<String> test() {
        return CompletableFuture.completedFuture(ptrVentaEcommerceService.test());
    }

    @Async
    @Override
    public CompletableFuture<String> getVersion() {
        return CompletableFuture.completedFuture(ptrVentaEcommerceService.version());
    }
}
