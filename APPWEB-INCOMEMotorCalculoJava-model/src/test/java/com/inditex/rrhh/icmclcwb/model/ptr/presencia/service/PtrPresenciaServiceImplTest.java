package com.inditex.rrhh.icmclcwb.model.ptr.presencia.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Map;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResponseDto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PtrPresenciaServiceImplTest {

  @Mock
  private RestClient ptrPresenciaClient;

  @Mock
  private Map<String, PtrPropertiesDto> presenciasProperties;

  @InjectMocks
  private PtrPresenciaServiceImpl ptrPresenciaService;

  @BeforeEach
  public void setup() {
    final PtrPropertiesDto properties = new PtrPropertiesDto();
    properties.setEndpoint("");
    when(this.presenciasProperties.get(any(String.class))).thenReturn(properties);
  }

  private <T extends Object> ResponseEntity<T> mockResponse(final T body) {
    final ResponseEntity<T> response = mock(ResponseEntity.class);
    when(response.getStatusCode()).thenReturn(HttpStatus.OK);
    when(response.getBody()).thenReturn(body);
    return response;
  }

  @Test
  public void presenciasTotalizadoTest() {

    final PtrPresenciaTotalizadoResponseDto result = PtrPresenciaTotalizadoResponseDto
        .builder()
        .presenciasTotalizado(new ArrayList<>())
        .build();
    final ResponseEntity<PtrPresenciaTotalizadoResponseDto> response = this.mockResponse(result);
    when(this.ptrPresenciaClient.postForEntity(any(String.class), any(PtrPresenciaTotalizadoRequestDto.class),
        eq(PtrPresenciaTotalizadoResponseDto.class))).thenReturn(response);
    assertEquals(result, this.ptrPresenciaService.presenciasTotalizado(new PtrPresenciaTotalizadoRequestDto()));

  }

  @Test
  public void presenciasDetalleTest() {

    final PtrPresenciaDetalleResponseDto result = PtrPresenciaDetalleResponseDto
        .builder()
        .presenciasDetalle(new ArrayList<>())
        .build();
    final ResponseEntity<PtrPresenciaDetalleResponseDto> response = this
        .mockResponse(result);
    when(this.ptrPresenciaClient.postForEntity(any(String.class), any(PtrPresenciaDetalleRequestDto.class),
        eq(PtrPresenciaDetalleResponseDto.class))).thenReturn(response);
    assertEquals(result, this.ptrPresenciaService.presenciasDetalle(new PtrPresenciaDetalleRequestDto()));

  }

  @Test
  public void tiposHorasTest() {

    final PtrPresenciaTiposHorasResponseDto result = PtrPresenciaTiposHorasResponseDto
        .builder()
        .tiposHoras(new ArrayList<>())
        .build();
    final ResponseEntity<PtrPresenciaTiposHorasResponseDto> response = this.mockResponse(
        result);
    when(this.ptrPresenciaClient.postForEntity(any(String.class), any(PtrPresenciaTiposHorasRequestDto.class),
        eq(PtrPresenciaTiposHorasResponseDto.class))).thenReturn(response);
    assertEquals(result, this.ptrPresenciaService.tiposHoras(new PtrPresenciaTiposHorasRequestDto()));

  }

  @Test
  public void presenciasTiendasEmpleadoTest() {

    final PtrPresenciaTiendasEmpleadoResponseDto result = PtrPresenciaTiendasEmpleadoResponseDto
        .builder()
        .presenciasTiendasEmpleado(new ArrayList<>())
        .build();
    final ResponseEntity<PtrPresenciaTiendasEmpleadoResponseDto> response = this.mockResponse(
        result);
    when(this.ptrPresenciaClient.postForEntity(any(String.class), any(PtrPresenciaTiendasEmpleadoRequestDto.class),
        eq(PtrPresenciaTiendasEmpleadoResponseDto.class))).thenReturn(response);
    assertEquals(result,
        this.ptrPresenciaService.presenciasTiendasEmpleado(new PtrPresenciaTiendasEmpleadoRequestDto()));

  }

  @Test
  public void presenciasEmpleadosTiendaTest() {

    final PtrPresenciaEmpleadosTiendaResponseDto result = PtrPresenciaEmpleadosTiendaResponseDto
        .builder()
        .presenciasTiendasEmpleado(new ArrayList<>())
        .build();
    final ResponseEntity<PtrPresenciaEmpleadosTiendaResponseDto> response = this.mockResponse(
        result);
    when(this.ptrPresenciaClient.postForEntity(any(String.class), any(PtrPresenciaEmpleadosTiendaRequestDto.class),
        eq(PtrPresenciaEmpleadosTiendaResponseDto.class))).thenReturn(response);
    assertEquals(result,
        this.ptrPresenciaService.presenciasEmpleadosTienda(new PtrPresenciaEmpleadosTiendaRequestDto()));

  }

}
