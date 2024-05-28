package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import java.util.Map;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
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
import com.inditex.rrhh.icmclcwb.model.app.util.RestUtils;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class PtrVentaEcommerceServiceImpl implements PtrVentaEcommerceService {

  @Autowired
  @Qualifier("ptrVentaClient")
  private RestClient ptrVentaClient;

  @Autowired
  @Qualifier("ventaEcommerceProperties")
  private Map<String, PtrPropertiesDto> ventaEcommerceProperties;

  @Retryable(maxAttemptsExpression = "${app.envars.ptr.config.max-attempts}")
  @Override
  public PtrVentaOnlineIpodResponseDto ventaOnlineiPod(
      @Valid final PtrVentaOnlineIpodRequestDto request) {
    return RestUtils.checkResponse(
        this.ptrVentaClient.postForEntity(
            this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD).getEndpoint(),
            request,
            PtrVentaOnlineIpodResponseDto.class),
        this.ptrVentaClient,
        this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD).getEndpoint(),
        request);
  }

  @Retryable(maxAttemptsExpression = "${app.envars.ptr.config.max-attempts}")
  @Override
  public PtrVentaOnlineIpodIndividualDetalleResponseDto ventaOnlineiPodIndividualDetalle(
      @Valid final PtrVentaOnlineIpodIndividualDetalleRequestDto request) {
    return RestUtils.checkResponse(
        this.ptrVentaClient.postForEntity(
            this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE)
                .getEndpoint(),
            request,
            PtrVentaOnlineIpodIndividualDetalleResponseDto.class),
        this.ptrVentaClient,
        this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE)
            .getEndpoint(),
        request);
  }

  @Retryable(maxAttemptsExpression = "${app.envars.ptr.config.max-attempts}")
  @Override
  public PtrVentaOnlineEntregaDomicilioResponseDto ventaOnlineEntregaDomicilio(
      @Valid final PtrVentaOnlineEntregaDomicilioRequestDto request) {
    return RestUtils.checkResponse(
        this.ptrVentaClient.postForEntity(
            this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_DOMICILIO)
                .getEndpoint(),
            request,
            PtrVentaOnlineEntregaDomicilioResponseDto.class),
        this.ptrVentaClient,
        this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_DOMICILIO).getEndpoint(),
        request);
  }

  @Retryable(maxAttemptsExpression = "${app.envars.ptr.config.max-attempts}")
  @Override
  public PtrVentaOnlineEntregaTiendaResponseDto ventaOnlineEntregaTienda(
      @Valid final PtrVentaOnlineEntregaTiendaRequestDto request) {
    return RestUtils.checkResponse(
        this.ptrVentaClient.postForEntity(
            this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA)
                .getEndpoint(),
            request,
            PtrVentaOnlineEntregaTiendaResponseDto.class),
        this.ptrVentaClient,
        this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA).getEndpoint(),
        request);
  }

  @Retryable(maxAttemptsExpression = "${app.envars.ptr.config.max-attempts}")
  @Override
  public PtrVentaOnlinePickingResponseDto ventaOnlinePicking(
      @Valid final PtrVentaOnlinePickingRequestDto request) {
    return RestUtils.checkResponse(
        this.ptrVentaClient.postForEntity(
            this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_PICKING).getEndpoint(),
            request,
            PtrVentaOnlinePickingResponseDto.class),
        this.ptrVentaClient,
        this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_PICKING).getEndpoint(),
        request);
  }

}
