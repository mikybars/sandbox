package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
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
import com.inditex.rrhh.icmclcwb.model.app.util.RestUtils;


@Service
@Validated
public class PtrVentaEcommerceServiceImpl implements PtrVentaEcommerceService {

    @Autowired
    @Qualifier("ptrVentaClient")
    private RestClient ptrVentaClient;
    
    @Autowired
    @Qualifier("ventaEcommerceProperties")
    private Map<String, PtrPropertiesDto> ventaEcommerceProperties;
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrVentaOnlineIpodResponseDto ventaOnlineiPod(
            @Valid final PtrVentaOnlineIpodRequestDto request) {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(
                        ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_IPOD).getEndpoint(), request,
                        PtrVentaOnlineIpodResponseDto.class),
                ptrVentaClient, ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_IPOD).getEndpoint(),
                request);
    }
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrVentaOnlineIpodIndividualDetalleResponseDto ventaOnlineiPodIndividualDetalle(
            @Valid final PtrVentaOnlineIpodIndividualDetalleRequestDto request) {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(
                        ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE).getEndpoint(), request,
                        PtrVentaOnlineIpodIndividualDetalleResponseDto.class),
                ptrVentaClient, ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE).getEndpoint(),
                request);
    }
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrVentaOnlineEntregaDomicilioResponseDto ventaOnlineEntregaDomicilio(
            @Valid final PtrVentaOnlineEntregaDomicilioRequestDto request) {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(
                        ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_ENTREGA_DOMICILIO).getEndpoint(), request,
                        PtrVentaOnlineEntregaDomicilioResponseDto.class),
                ptrVentaClient, ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_ENTREGA_DOMICILIO).getEndpoint(),
                request);
    }
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrVentaOnlineEntregaTiendaResponseDto ventaOnlineEntregaTienda(
            @Valid final PtrVentaOnlineEntregaTiendaRequestDto request) {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(
                        ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_ENTREGA_TIENDA).getEndpoint(), request,
                        PtrVentaOnlineEntregaTiendaResponseDto.class),
                ptrVentaClient, ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_ENTREGA_TIENDA).getEndpoint(),
                request);
    }
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrVentaOnlinePickingResponseDto ventaOnlinePicking(
            @Valid final PtrVentaOnlinePickingRequestDto request) {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(
                        ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_PICKING).getEndpoint(), request,
                        PtrVentaOnlinePickingResponseDto.class),
                ptrVentaClient, ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_PICKING).getEndpoint(),
                request);
    }
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrVentaOrdersByCountryHourResponseDto ordersByCountryHour(
            @Valid final PtrVentaOrdersByCountryHourRequestDto request) {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(
                        ventaEcommerceProperties.get(PtrConstants.ORDERS_BY_COUNTRY_HOUR).getEndpoint(), request,
                        PtrVentaOrdersByCountryHourResponseDto.class),
                ptrVentaClient, ventaEcommerceProperties.get(PtrConstants.ORDERS_BY_COUNTRY_HOUR).getEndpoint(),
                request);
    }
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrVentaOrdersByCountryMinuteResponseDto ordersByCountryMinute(
            @Valid final PtrVentaOrdersByCountryMinuteRequestDto request) {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(
                        ventaEcommerceProperties.get(PtrConstants.ORDERS_BY_COUNTRY_MINUTE).getEndpoint(), request,
                        PtrVentaOrdersByCountryMinuteResponseDto.class),
                ptrVentaClient, ventaEcommerceProperties.get(PtrConstants.ORDERS_BY_COUNTRY_MINUTE).getEndpoint(),
                request);
    }    
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrVentaOrdersByCountrySectionProductHourResponseDto ordersByCountrySectionProductHour(
            @Valid final PtrVentaOrdersByCountrySectionProductHourRequestDto request) {
        return RestUtils.checkResponse( 
                ptrVentaClient.postForEntity(
                        ventaEcommerceProperties.get(PtrConstants.ORDERS_BY_COUNTRY_SECTION_PRODUCT_HOUR).getEndpoint(), request,
                        PtrVentaOrdersByCountrySectionProductHourResponseDto.class),
                ptrVentaClient, ventaEcommerceProperties.get(PtrConstants.ORDERS_BY_COUNTRY_SECTION_PRODUCT_HOUR).getEndpoint(),
                request);
    }
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrVentaOrdersByCountrySectionProductMinuteResponseDto ordersByCountrySectionProductMinute(
            @Valid final PtrVentaOrdersByCountrySectionProductMinuteRequestDto request) {
        return RestUtils.checkResponse( 
                ptrVentaClient.postForEntity( 
                        ventaEcommerceProperties.get(PtrConstants.ORDERS_BY_COUNTRY_SECTION_PRODUCT_MINUTE).getEndpoint(), request,
                        PtrVentaOrdersByCountrySectionProductMinuteResponseDto.class),
                ptrVentaClient, ventaEcommerceProperties.get(PtrConstants.ORDERS_BY_COUNTRY_SECTION_PRODUCT_MINUTE).getEndpoint(),
                request);
    }
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public String test() {
        return RestUtils.checkResponse(
                ptrVentaClient.getForEntity(ventaEcommerceProperties.get(PtrConstants.VENTA_EMPLEADO_TEST).getEndpoint(),
                        String.class),
                ptrVentaClient, ventaEcommerceProperties.get(PtrConstants.VENTA_EMPLEADO_TEST).getEndpoint(), null);
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public String version() {
        return RestUtils.checkResponse(
                ptrVentaClient.getForEntity(
                        ventaEcommerceProperties.get(PtrConstants.VENTA_EMPLEADO_VERSION).getEndpoint(), String.class),
                ptrVentaClient, ventaEcommerceProperties.get(PtrConstants.VENTA_EMPLEADO_VERSION).getEndpoint(), null);
    }
    
}
