/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.slrhorcoms.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.slrhorcoms.authenticate.dto.AuthenticateDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.authenticate.dto.AuthenticateResponseDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.SlrhorcomsPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.exception.SlrhorcomsIcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.service.SlrHorarioComercialService;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.util.HorarioComercialPropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.RestUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;

import com.inditex.aqsw.framework.common.rest.client.RestClient;

@Service
@Validated
public class SlrHorarioComercialServiceImpl implements SlrHorarioComercialService {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("slrhorcomsClient")
    private RestClient slrhorcomsClient;

    @Autowired
    @Qualifier("slrhorcomsProperties")
    private Map<String, SlrhorcomsPropertiesDto> slrhorcomsProperties;

    @Autowired
    private TareaMapper tareaMapper;


    @Override
    public List<HorarioComercialFestivoDocDto> horarioComercialFestivos(
            final HorarioComercialFestivosRequestDto request) {
        this.authenticate();
        final SlrhorcomsPropertiesDto properties = this.slrhorcomsProperties
            .get(HorarioComercialPropertiesConstants.HORARIO_COMERCIAL_FESTIVO);

        final String query = this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request);
        this.log.info("horario comercial festivos query: {}", query);

        final StringBuilder url = new StringBuilder()
            .append(properties.getEndpoint())
            .append(query);

        final HorarioComercialFestivoDocDto[] response = RestUtils.checkResponse(this.slrhorcomsClient
            .getForEntity(url.toString(),
                    HorarioComercialFestivoDocDto[].class),
                this.slrhorcomsClient,
                properties.getEndpoint(), request);

        request.setHasNext(response.length == request.getRows());
        request.setStart(request.getStart() + request.getRows());

        return Arrays.asList(response);
    }

    /**
     * Autentica con el servicio siempre y cuando sea necesario...
     */
    private AuthenticateDto authenticate() {
        final ResponseEntity<AuthenticateResponseDto> responseAuthenticate = this.slrhorcomsClient
            .postForEntity(HorarioComercialPropertiesConstants.AUTHENTICATE, null, AuthenticateResponseDto.class);
        this.log.info("responseAuthenticate: {}", responseAuthenticate);
        if (responseAuthenticate.getStatusCode().value() != HttpStatus.SC_OK) {
            throw new SlrhorcomsIcmclcwbException("Error en login slrhorcomsI");
        }
        return AuthenticateDto.builder()
            .message(responseAuthenticate.getBody().getMessage())
            .accessToken(responseAuthenticate.getHeaders().getFirst("access-token"))
            .refreshToken(responseAuthenticate.getHeaders().getFirst("refresh-token"))
            .build();
    }

}
