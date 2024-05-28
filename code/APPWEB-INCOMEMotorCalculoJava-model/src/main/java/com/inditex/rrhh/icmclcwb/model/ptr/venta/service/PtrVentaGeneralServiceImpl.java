package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import java.util.Map;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaGeneralService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.util.RestUtils;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class PtrVentaGeneralServiceImpl implements PtrVentaGeneralService {

  @Autowired
  @Qualifier("ptrVentaClient")
  private RestClient ptrVentaClient;

  @Autowired
  @Qualifier("ventaGeneralProperties")
  private Map<String, PtrPropertiesDto> ventaGeneralProperties;

  @Retryable(maxAttemptsExpression = "${app.envars.ptr.config.max-attempts}")
  @Override
  public PtrVentaTotalizadoResponseDto ventaTotalizado(@Valid final PtrVentaTotalizadoRequestDto request) {
    return RestUtils.checkResponse(
        this.ptrVentaClient.postForEntity(
            this.ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO).getEndpoint(),
            request, PtrVentaTotalizadoResponseDto.class),
        this.ptrVentaClient,
        this.ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO).getEndpoint(),
        request);
  }

}
