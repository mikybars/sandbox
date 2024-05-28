package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import java.util.Map;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaEmpleadoService;
import com.inditex.rrhh.icmclcwb.model.app.util.RestUtils;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class PtrVentaEmpleadoServiceImpl implements PtrVentaEmpleadoService {

  @Autowired
  @Qualifier("ptrVentaClient")
  private RestClient ptrVentaClient;

  @Autowired
  @Qualifier("ventaEmpleadoProperties")
  private Map<String, PtrPropertiesDto> ventaEmpleadoProperties;

  @Retryable(maxAttemptsExpression = "${app.envars.ptr.config.max-attempts}")
  @Override
  public PtrVentaIndividualDetalleResponseDto ventaIndividualDetalle(
      @Valid final PtrVentaIndividualDetalleRequestDto request) {
    return RestUtils.checkResponse(
        this.ptrVentaClient.postForEntity(
            this.ventaEmpleadoProperties.get(PtrPropertiesConstants.VENTA_INDIVIDUAL_DETALLE).getEndpoint(),
            request,
            PtrVentaIndividualDetalleResponseDto.class),
        this.ptrVentaClient,
        this.ventaEmpleadoProperties.get(PtrPropertiesConstants.VENTA_INDIVIDUAL_DETALLE).getEndpoint(),
        request);
  }

}
