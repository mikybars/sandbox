package com.inditex.rrhh.icmclcwb.model.app.service;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraDataResponseDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraRequestDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraResponseDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.exception.VentaIntegraIcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.service.VentaIntegraService;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.util.VentaIntegraClientPropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.app.annotation.AntiguoMotor;
import com.inditex.rrhh.icmclcwb.model.app.util.RestUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Component
@AntiguoMotor
public class VentaIntegraServiceImpl implements VentaIntegraService {

  private static final Logger LOG = LoggerFactory.getLogger(VentaIntegraServiceImpl.class);

  @Autowired
  @Qualifier("ventaIntegraClient")
  private RestClient ventaIntegraClient;

  @Autowired
  @Qualifier("ventaIntegraProperties")
  private VentaIntegraPropertiesDto ventaIntegraProperties;

  @Override
  public List<VentaIntegraDataResponseDto> getTiendasVentaNoIntegra(final VentaIntegraRequestDto request) {
    final VentaIntegraResponseDto response;
    try {
      response = this.queryTiendasVentaNoIntegra(request);

    } catch (final VentaIntegraIcmclcwbException e) {
      throw e;
    }

    return response.getData();
  }

  @Retryable(maxAttemptsExpression = "${app.envars.venta-integra.config.max-attempts}")
  private VentaIntegraResponseDto queryTiendasVentaNoIntegra(final VentaIntegraRequestDto request) {

    final Map<String, String> pathParams = new HashMap<>();
    pathParams.put("countryTic", request.getIdOrigen().toString());
    pathParams.put("from", request.getFechaDesde());
    pathParams.put("to", request.getFechaHasta());
    pathParams.put("groupCompanyTic", request.getIdEmpresa().toString());
    pathParams.put("storeTics", request.getListaTiendas().stream().map(String::valueOf)
        .collect(Collectors.joining(",")));

    if (request.getFechaLimite() != null) {
      pathParams.put("before", request.getFechaLimite().toString());
    }

    final String url = this.ventaIntegraProperties.getEndpoint()
        + this.getUrlParams(request);

    try {
      return RestUtils.checkResponse(
          this.ventaIntegraClient.getForEntity(
              url, VentaIntegraResponseDto.class, pathParams),
          this.ventaIntegraClient,
          url, pathParams);
    } catch (final Exception e) {
      throw new VentaIntegraIcmclcwbException("Error en el cliente VentaIntegra [url: " + url + ", values: " + pathParams.values() + "]",
          e);
    }

  }

  private String getUrlParams(final VentaIntegraRequestDto request) {
    final StringBuilder urlParams = new StringBuilder();
    urlParams.append(VentaIntegraClientPropertiesConstants.INTERROGACION);

    urlParams.append(VentaIntegraClientPropertiesConstants.ID_ORIGEN)
        .append(VentaIntegraClientPropertiesConstants.EQUALS_TO)
        .append(VentaIntegraClientPropertiesConstants.ABRIR_LLAVE)
        .append(VentaIntegraClientPropertiesConstants.ID_ORIGEN)
        .append(VentaIntegraClientPropertiesConstants.CERRAR_LLAVE);

    urlParams.append(VentaIntegraClientPropertiesConstants.AND);
    urlParams.append(VentaIntegraClientPropertiesConstants.ID_EMPRESA)
        .append(VentaIntegraClientPropertiesConstants.EQUALS_TO)
        .append(VentaIntegraClientPropertiesConstants.ABRIR_LLAVE)
        .append(VentaIntegraClientPropertiesConstants.ID_EMPRESA)
        .append(VentaIntegraClientPropertiesConstants.CERRAR_LLAVE);

    urlParams.append(VentaIntegraClientPropertiesConstants.AND);
    urlParams.append(VentaIntegraClientPropertiesConstants.FECHA_DESDE)
        .append(VentaIntegraClientPropertiesConstants.EQUALS_TO)
        .append(VentaIntegraClientPropertiesConstants.ABRIR_LLAVE)
        .append(VentaIntegraClientPropertiesConstants.FECHA_DESDE)
        .append(VentaIntegraClientPropertiesConstants.CERRAR_LLAVE);

    urlParams.append(VentaIntegraClientPropertiesConstants.AND);
    urlParams.append(VentaIntegraClientPropertiesConstants.FECHA_HASTA)
        .append(VentaIntegraClientPropertiesConstants.EQUALS_TO)
        .append(VentaIntegraClientPropertiesConstants.ABRIR_LLAVE)
        .append(VentaIntegraClientPropertiesConstants.FECHA_HASTA)
        .append(VentaIntegraClientPropertiesConstants.CERRAR_LLAVE);

    urlParams.append(VentaIntegraClientPropertiesConstants.AND);
    urlParams.append(VentaIntegraClientPropertiesConstants.LISTA_TIENDAS)
        .append(VentaIntegraClientPropertiesConstants.EQUALS_TO)
        .append(VentaIntegraClientPropertiesConstants.ABRIR_LLAVE)
        .append(VentaIntegraClientPropertiesConstants.LISTA_TIENDAS)
        .append(VentaIntegraClientPropertiesConstants.CERRAR_LLAVE);

    if (request.getFechaLimite() != null) {
      urlParams.append(VentaIntegraClientPropertiesConstants.AND);
      urlParams.append(VentaIntegraClientPropertiesConstants.FECHA_LIMITE)
          .append(VentaIntegraClientPropertiesConstants.EQUALS_TO)
          .append(VentaIntegraClientPropertiesConstants.ABRIR_LLAVE)
          .append(VentaIntegraClientPropertiesConstants.FECHA_LIMITE)
          .append(VentaIntegraClientPropertiesConstants.CERRAR_LLAVE);
    }

    return urlParams.toString();
  }
}
