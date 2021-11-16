package com.inditex.rrhh.icmclcwb.model.slrhorcoms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.authenticate.dto.AuthenticateResponseDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.ResponseDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.SlrhorcomsPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.exception.SlrhorcomsIcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.util.HorarioComercialPropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class SlrHorarioComercialServiceImplTest {

  private static final String ENDPOINT_AUTHENTICATE = "/auth";

  private static final String ENDPOINT_FESTIVOS = "/festivos";

  @Mock
  private RestClient slrhorcomsClient;

  @Mock
  private Map<String, SlrhorcomsPropertiesDto> slrhorcomsProperties;

  @Mock
  private Logger log;

  @Mock
  private TareaMapper tareaMapper;

  @InjectMocks
  private SlrHorarioComercialServiceImpl slrHorarioComercialService;

  private final HorarioComercialFestivoDocDto horaioComercial = HorarioComercialFestivoDocDto
      .builder()
      .idTienda(10000)
      .fecha("Fri Jan 01 01:00:00 CET 2021")
      .festivo("Año nuevo")
      .codigo("11")
      .cadena("Oysho")
      .idCadena(7)
      .pais("ESPAÑA")
      .tienda("GIR-BISBE LORENZANA")
      .idPais(11)
      .build();

  @BeforeEach
  public void setup() {
    final SlrhorcomsPropertiesDto propertiesAuthenticate = new SlrhorcomsPropertiesDto();
    propertiesAuthenticate.setEndpoint(ENDPOINT_AUTHENTICATE);
    when(this.slrhorcomsProperties.get(HorarioComercialPropertiesConstants.AUTHENTICATE))
        .thenReturn(propertiesAuthenticate);

    final ResponseEntity<AuthenticateResponseDto> responseAuthenticate = this.mockResponse(
        new AuthenticateResponseDto());
    when(responseAuthenticate.getBody()).thenReturn(new AuthenticateResponseDto());
    when(responseAuthenticate.getHeaders()).thenReturn(new HttpHeaders());
    when(this.slrhorcomsClient.postForEntity(ENDPOINT_AUTHENTICATE, null,
        AuthenticateResponseDto.class))
            .thenReturn(responseAuthenticate);

    final SlrhorcomsPropertiesDto properties = new SlrhorcomsPropertiesDto();
    properties.setEndpoint(ENDPOINT_FESTIVOS);
    when(this.slrhorcomsProperties.get(HorarioComercialPropertiesConstants.HORARIO_COMERCIAL_FESTIVO))
        .thenReturn(properties);

    final ResponseEntity<HorarioComercialFestivoDocDto[]> responseMock = this.mockResponse(
        new HorarioComercialFestivoDocDto[]{this.horaioComercial});
    when(this.slrhorcomsClient.getForEntity(any(String.class), eq(HorarioComercialFestivoDocDto[].class)))
        .thenReturn(responseMock);
    when(this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(any(HorarioComercialFestivosRequestDto.class)))
        .thenReturn("q=*");
  }

  private <T extends Object> ResponseEntity<T> mockResponse(final T body) {
    final ResponseEntity<T> response = mock(ResponseEntity.class);
    when(response.getStatusCode()).thenReturn(HttpStatus.OK);
    when(response.getBody()).thenReturn(body);
    return response;
  }

  @Test
  void festivosTest() {
    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();
    request.setStart(0);
    request.setRows(100);
    final ResponseDto<HorarioComercialFestivoDocDto> response = this.slrHorarioComercialService
        .horarioComercialFestivos(request);
    final List<HorarioComercialFestivoDocDto> actualValue = response
        .getDocs();
    assertEquals(1, actualValue.size());
    assertEquals(this.horaioComercial, actualValue.get(0));
    assertFalse(response.isHasNext());
  }

  @Test
  void festivosHasNextTest() {
    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();
    request.setStart(0);
    request.setRows(1);
    final ResponseDto<HorarioComercialFestivoDocDto> response = this.slrHorarioComercialService
        .horarioComercialFestivos(request);
    final List<HorarioComercialFestivoDocDto> actualValue = response
        .getDocs();
    assertEquals(1, actualValue.size());
    assertEquals(this.horaioComercial, actualValue.get(0));
    assertTrue(response.isHasNext());
  }

  @Test
  void festivosExceptionTest() {
    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();
    request.setStart(0);
    request.setRows(1);
    doThrow(new RuntimeException("e")).when(this.slrhorcomsClient)
        .getForEntity(any(String.class), any(Class.class));

    assertThrows(SlrhorcomsIcmclcwbException.class,
        () -> this.slrHorarioComercialService.horarioComercialFestivos(request));
  }

}
