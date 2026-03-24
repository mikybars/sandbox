package com.inditex.rrhh.icmclcwb.model.iopcomercialcalendar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.authenticate.dto.AuthenticateResponseDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.dto.EndpointResponseDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.dto.IopcomercialcalendarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.dto.ResponseDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.exception.IopcomercialcalendarIcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.util.HorarioComercialPropertiesConstants;
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
class IOPComercialCalendarServiceImplTest {

  private static final String ENDPOINT_AUTHENTICATE = "/auth";

  private static final String ENDPOINT_FESTIVOS = "/v1/holidays?";

  @Mock
  private RestClient iopcomercialcalendarClient;

  @Mock
  private Map<String, IopcomercialcalendarPropertiesDto> iopcomercialcalendarProperties;

  @Mock
  private Logger log;

  @Mock
  private TareaMapper tareaMapper;

  @InjectMocks
  private IOPComercialCalendarCalendarServiceImpl iopcomercialcalendarService;

  private final HorarioComercialFestivoDocDto horarioComercial = HorarioComercialFestivoDocDto
      .builder()
      .date("2021-01-01")
      .name("Año nuevo")
      .storeId("GIR-BISBE LORENZANA")
      .build();

  @BeforeEach
  void setup() {
    final IopcomercialcalendarPropertiesDto propertiesAuthenticate = new IopcomercialcalendarPropertiesDto();
    propertiesAuthenticate.setEndpoint(ENDPOINT_AUTHENTICATE);
    when(this.iopcomercialcalendarProperties.get(HorarioComercialPropertiesConstants.AUTHENTICATE))
        .thenReturn(propertiesAuthenticate);

    final ResponseEntity<AuthenticateResponseDto> responseAuthenticate = this.mockResponse(
        new AuthenticateResponseDto());
    when(responseAuthenticate.getBody()).thenReturn(new AuthenticateResponseDto());
    when(responseAuthenticate.getHeaders()).thenReturn(new HttpHeaders());
    when(this.iopcomercialcalendarClient.postForEntity(ENDPOINT_AUTHENTICATE, null,
        AuthenticateResponseDto.class))
            .thenReturn(responseAuthenticate);

    final IopcomercialcalendarPropertiesDto properties = new IopcomercialcalendarPropertiesDto();
    properties.setEndpoint(ENDPOINT_FESTIVOS);
    when(this.iopcomercialcalendarProperties.get(HorarioComercialPropertiesConstants.HORARIO_COMERCIAL_FESTIVO))
        .thenReturn(properties);

    final EndpointResponseDto endpointResponseDto = new EndpointResponseDto();
    endpointResponseDto.setData(List.of(this.horarioComercial));
    final ResponseEntity<EndpointResponseDto> responseMock = this.mockResponse(endpointResponseDto);
    when(this.iopcomercialcalendarClient.getForEntity(any(String.class), eq(EndpointResponseDto.class)))
        .thenReturn(responseMock);
    when(this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(any(HorarioComercialFestivosRequestDto.class)))
        .thenReturn("storeIds=");
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
    final ResponseDto<HorarioComercialFestivoDocDto> response = this.iopcomercialcalendarService
        .horarioComercialFestivos(request);
    final List<HorarioComercialFestivoDocDto> actualValue = response
        .getData();
    assertEquals(1, actualValue.size());
    assertEquals(this.horarioComercial, actualValue.get(0));
  }

  @Test
  void festivosExceptionTest() {
    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();
    doThrow(new RuntimeException("e")).when(this.iopcomercialcalendarClient)
        .getForEntity(any(String.class), any(Class.class));
    assertThrows(IopcomercialcalendarIcmclcwbException.class,
        () -> this.iopcomercialcalendarService.horarioComercialFestivos(request));
  }

}
