package com.inditex.rrhh.icmclcwb.model.app.service;

/*
 * Copyright (c) 2022. Inditex
 */
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

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraDataResponseDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraMetadaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraRequestDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraResponseDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraStatisticsResponseDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.exception.VentaIntegraIcmclcwbException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class VentaIntegraServiceImplTest {

  @Mock
  private RestClient ventaIntegraClient;

  @Mock
  private VentaIntegraPropertiesDto ventaIntegraProperties;

  @Mock
  private Logger log;

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

    final VentaIntegraRequestDto ventaIntegraRequestDto = VentaIntegraRequestDto.builder().idOrigen(60).idEmpresa(179)
        .fechaDesde("2022-03-23").fechaHasta("2022-04-23").listaTiendas(Arrays.asList(1, 2, 3, 4))
        .fechaLimite(LocalDateTime.now()).build();

    final List<VentaIntegraDataResponseDto> listData = Arrays.asList(VentaIntegraDataResponseDto.builder().storeTic(1).build(),
        VentaIntegraDataResponseDto.builder().storeTic(2).build());

    final VentaIntegraResponseDto ventaIntegraResponseDto = VentaIntegraResponseDto.builder()
        .metadata(this.ventaIntegraMetadaResponseDto).statistics(this.ventaIntegraStatisticsResponseDto)
        .data(listData).build();

    final ResponseEntity<VentaIntegraResponseDto> responseMock = this.mockResponse(ventaIntegraResponseDto);

    doReturn("/service/storedata?").when(this.ventaIntegraProperties)
        .getEndpoint();
    doReturn(responseMock).when(this.ventaIntegraClient).getForEntity(any(String.class),
        eq(VentaIntegraResponseDto.class), any(Map.class));

    final List<VentaIntegraDataResponseDto> tiendasNoIntegras =
        this.ventaIntegraService.getTiendasVentaNoIntegra(ventaIntegraRequestDto);

    verify(this.ventaIntegraClient, times(1)).getForEntity(any(String.class),
        eq(VentaIntegraResponseDto.class), any(Map.class));
  }

  @Test
  void getTiendasVentaNoIntegraWithoutBeforeParamTest() {

    final VentaIntegraRequestDto ventaIntegraRequestDto = VentaIntegraRequestDto.builder().idOrigen(60).idEmpresa(179)
        .fechaDesde("2022-03-23").fechaHasta("2022-04-23").listaTiendas(Arrays.asList(1, 2, 3, 4)).build();

    final List<VentaIntegraDataResponseDto> listData = Arrays.asList(VentaIntegraDataResponseDto.builder().storeTic(1).build(),
        VentaIntegraDataResponseDto.builder().storeTic(2).build());

    final VentaIntegraResponseDto ventaIntegraResponseDto = VentaIntegraResponseDto.builder()
        .metadata(this.ventaIntegraMetadaResponseDto).statistics(this.ventaIntegraStatisticsResponseDto)
        .data(listData).build();

    final ResponseEntity<VentaIntegraResponseDto> responseMock = this.mockResponse(ventaIntegraResponseDto);

    doReturn("/service/storedata?").when(this.ventaIntegraProperties)
        .getEndpoint();
    doReturn(responseMock).when(this.ventaIntegraClient).getForEntity(any(String.class),
        eq(VentaIntegraResponseDto.class), any(Map.class));

    final List<VentaIntegraDataResponseDto> tiendasNoIntegras =
        this.ventaIntegraService.getTiendasVentaNoIntegra(ventaIntegraRequestDto);

    verify(this.ventaIntegraClient, times(1)).getForEntity(any(String.class),
        eq(VentaIntegraResponseDto.class), any(Map.class));
  }

  @Test
  void getTiendasVentaNoIntegraExceptionTest() {
    final VentaIntegraRequestDto ventaIntegraRequestDto = VentaIntegraRequestDto.builder().idOrigen(60).idEmpresa(179)
        .fechaDesde("2022-03-23").fechaHasta("2022-04-23").listaTiendas(Arrays.asList(1, 2, 3, 4))
        .fechaLimite(LocalDateTime.now()).build();

    final List<VentaIntegraDataResponseDto> listData = Arrays.asList(VentaIntegraDataResponseDto.builder().storeTic(1).build(),
        VentaIntegraDataResponseDto.builder().storeTic(2).build());

    doReturn("/service/storedata?").when(this.ventaIntegraProperties)
        .getEndpoint();
    doThrow(new VentaIntegraIcmclcwbException("")).when(this.ventaIntegraClient).getForEntity(any(String.class),
        eq(VentaIntegraResponseDto.class), any(Map.class));

    assertThrows(VentaIntegraIcmclcwbException.class, () -> {
      this.ventaIntegraService.getTiendasVentaNoIntegra(ventaIntegraRequestDto);
    });
  }

}
