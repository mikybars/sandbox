package com.inditex.rrhh.icmclcwb.model.app.service;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.app.dto.VentaIntegraPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.VentaIntegraRequestDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.VentaIntegraResponseDto;
import com.inditex.rrhh.icmclcwb.api.app.service.VentaIntegraService;
import com.inditex.rrhh.icmclcwb.model.app.util.RestUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Component
public class VentaIntegraServiceImpl implements VentaIntegraService {

  public static final String VENTA_INTEGRA = "venta-integra";

  @Autowired
  @Qualifier("ventaIntegraClient")
  private RestClient ventaIntegraClient;

  @Autowired
  @Qualifier("ventaIntegraProperties")
  private Map<String, VentaIntegraPropertiesDto> ventaIntegraProperties;

  @Override
  public List<Integer> getTiendasVentaNoIntegra(VentaIntegraRequestDto request) {

    VentaIntegraResponseDto response = queryTiendasVentaNoIntegra(request);

    return response.getData().stream().map(x -> x.getStoreTic()).collect(Collectors.toList());
  }

  @Retryable(maxAttemptsExpression = "${app.envars.venta-integra.config.max-attempts}")
  private VentaIntegraResponseDto queryTiendasVentaNoIntegra(VentaIntegraRequestDto request) {
    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("countryTic", request.getIdOrigen().toString());
    pathParams.put("from", request.getFechaDesde());
    pathParams.put("to", request.getFechaHasta());
    pathParams.put("groupCompanyTic", request.getIdEmpresa().toString());
    pathParams.put("storeTics", request.getListaTiendas().stream().map(String::valueOf)
        .collect(Collectors.joining(",")));
    if (request.getFechaLimite() != null) {
      pathParams.put("before", request.getFechaLimite().toString());
    }

    ResponseEntity<VentaIntegraResponseDto> resultado = null;
    if (request.getFechaLimite() != null) {
      resultado = this.ventaIntegraClient.getForEntity(
          // this.ventaIntegraProperties.get(VENTA_INTEGRA).getEndpoint(),
          "/service/storedata?from={from}&to={to}&countryTic={countryTic}&groupCompanyTic={groupCompanyTic}&storeTics={storeTics}&before={before}",
          VentaIntegraResponseDto.class, pathParams);
    } else {
      resultado = this.ventaIntegraClient.getForEntity(
          // this.ventaIntegraProperties.get(VENTA_INTEGRA).getEndpoint(),
          "/service/storedata?from={from}&to={to}&countryTic={countryTic}&groupCompanyTic={groupCompanyTic}&storeTics={storeTics}",
          VentaIntegraResponseDto.class, pathParams);
    }

    return RestUtils.checkResponse(
        resultado,
        this.ventaIntegraClient,
        // this.ventaIntegraProperties.get(VENTA_INTEGRA).getEndpoint(),
        "/service/storedata?from={from}",
        request);
  }
}
