package com.inditex.rrhh.icmclcwb.model.slrhorcoms.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.rrhh.icmclcwb.api.slrhorcoms.authenticate.dto.AuthenticateResponseDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.SlrhorcomsPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.util.HorarioComercialPropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;

import com.inditex.aqsw.framework.common.rest.client.RestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class SlrHorarioComercialServiceImplTest {

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
    }

    private <T extends Object> ResponseEntity<T> mockResponse(final T body) {
        final ResponseEntity<T> response = mock(ResponseEntity.class);
        when(response.getStatusCode()).thenReturn(HttpStatus.OK);
        when(response.getBody()).thenReturn(body);
        return response;
    }

    @Test
    public void festivosTest() {
        final HorarioComercialFestivoDocDto result = HorarioComercialFestivoDocDto
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

        final SlrhorcomsPropertiesDto properties = new SlrhorcomsPropertiesDto();
        properties.setEndpoint(ENDPOINT_FESTIVOS);
        when(this.slrhorcomsProperties.get(HorarioComercialPropertiesConstants.HORARIO_COMERCIAL_FESTIVO))
            .thenReturn(properties);

        final ResponseEntity<HorarioComercialFestivoDocDto[]> response = this.mockResponse(
                new HorarioComercialFestivoDocDto[] { result });
        when(this.slrhorcomsClient.getForEntity(any(String.class), eq(HorarioComercialFestivoDocDto[].class)))
            .thenReturn(response);
        when(this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(any(HorarioComercialFestivosRequestDto.class)))
            .thenReturn("q=*");

        final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();
        request.setStart(0);
        request.setRows(100);
        final List<HorarioComercialFestivoDocDto> actualValue = this.slrHorarioComercialService
            .horarioComercialFestivos(request)
            .getDocs();
        assertEquals(1, actualValue.size());
        assertEquals(result, actualValue.get(0));
    }

}
