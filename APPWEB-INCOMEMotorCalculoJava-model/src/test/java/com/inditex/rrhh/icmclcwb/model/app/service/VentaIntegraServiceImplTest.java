package com.inditex.rrhh.icmclcwb.model.app.service;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraDataResponseDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraMetadaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraRequestDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraResponseDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraStatisticsResponseDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.exception.VentaIntegraIcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.util.VentaIntegraClientPropertiesConstants;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class VentaIntegraServiceImplTest {

  @Mock
  private RestClient ventaIntegraClient;

  @Mock
  private Map<String, VentaIntegraPropertiesDto> ventaIntegraProperties;

  @InjectMocks
  VentaIntegraServiceImpl ventaIntegraService;

  @Random
  VentaIntegraMetadaResponseDto ventaIntegraMetadaResponseDto;

  @Random
  VentaIntegraStatisticsResponseDto ventaIntegraStatisticsResponseDto;

  private <T extends Object> ResponseEntity<T> mockResponse(final T body) {
    final ResponseEntity<T> response = mock(ResponseEntity.class);
    when(response.getStatusCode()).thenReturn(HttpStatus.OK);
    when(response.getBody()).thenReturn(body);
    return response;
  }

  @Test
  void getTiendasVentaNoIntegraTest() {

    VentaIntegraRequestDto ventaIntegraRequestDto = VentaIntegraRequestDto.builder().idOrigen(60).idEmpresa(179)
        .fechaDesde("2022-03-23").fechaHasta("2022-04-23").listaTiendas(Arrays.asList(1, 2, 3, 4))
        .fechaLimite(LocalDateTime.now()).build();

    List<VentaIntegraDataResponseDto> listData = Arrays.asList(VentaIntegraDataResponseDto.builder().storeTic(1).build(),
        VentaIntegraDataResponseDto.builder().storeTic(2).build());

    VentaIntegraResponseDto ventaIntegraResponseDto = VentaIntegraResponseDto.builder()
        .metadata(this.ventaIntegraMetadaResponseDto).statistics(this.ventaIntegraStatisticsResponseDto)
        .data(listData).build();

    final ResponseEntity<VentaIntegraResponseDto> responseMock = this.mockResponse(ventaIntegraResponseDto);

    doReturn(new VentaIntegraPropertiesDto("/service/storedata?")).when(this.ventaIntegraProperties)
        .get(VentaIntegraClientPropertiesConstants.VENTA_INTEGRA);
    doReturn(responseMock).when(this.ventaIntegraClient).getForEntity(any(String.class),
        eq(VentaIntegraResponseDto.class), any(Map.class));

    List<Integer> tiendasNoIntegras = this.ventaIntegraService.getTiendasVentaNoIntegra(ventaIntegraRequestDto);

    assertEquals(tiendasNoIntegras, Arrays.asList(1, 2));
    verify(this.ventaIntegraClient, times(1)).getForEntity(any(String.class),
        eq(VentaIntegraResponseDto.class), any(Map.class));
  }

  @Test
  void getTiendasVentaNoIntegraExceptionTest() {
    VentaIntegraRequestDto ventaIntegraRequestDto = VentaIntegraRequestDto.builder().idOrigen(60).idEmpresa(179)
        .fechaDesde("2022-03-23").fechaHasta("2022-04-23").listaTiendas(Arrays.asList(1, 2, 3, 4))
        .fechaLimite(LocalDateTime.now()).build();

    List<VentaIntegraDataResponseDto> listData = Arrays.asList(VentaIntegraDataResponseDto.builder().storeTic(1).build(),
        VentaIntegraDataResponseDto.builder().storeTic(2).build());

    doReturn(new VentaIntegraPropertiesDto("/service/storedata?")).when(this.ventaIntegraProperties)
        .get(VentaIntegraClientPropertiesConstants.VENTA_INTEGRA);
    doThrow(new VentaIntegraIcmclcwbException("")).when(this.ventaIntegraClient).getForEntity(any(String.class),
        eq(VentaIntegraResponseDto.class), any(Map.class));

    assertThrows(VentaIntegraIcmclcwbException.class, () -> {
      this.ventaIntegraService.getTiendasVentaNoIntegra(ventaIntegraRequestDto);
    });
  }

}
