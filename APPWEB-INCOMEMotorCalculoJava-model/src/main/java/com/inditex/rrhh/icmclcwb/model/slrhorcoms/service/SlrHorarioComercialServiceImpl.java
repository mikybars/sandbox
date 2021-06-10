/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.slrhorcoms.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
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

    @Value("${app.envars.slrhorcoms.config.timeout}")
    private Long timeout;

    @Value("${app.envars.slrhorcoms.config.refresh-timeout}")
    private Long refreshTimeout;

    private AuthenticateDto session;


    @Override
    @Cacheable(value = "itx.icmlcwb.horario_comercial_festivos", key = "{#request}")
    public List<HorarioComercialFestivoDocDto> horarioComercialFestivos(
            final HorarioComercialFestivosRequestDto request) {
        // this.checkSession();
        final SlrhorcomsPropertiesDto properties = this.slrhorcomsProperties
            .get(HorarioComercialPropertiesConstants.HORARIO_COMERCIAL_FESTIVO);

        final String query = this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request);
        this.log.info("horario comercial festivos query: {}", query);

        final StringBuilder url = new StringBuilder()
            .append(properties.getEndpoint())
            .append(query);

        final HttpHeaders headers = new HttpHeaders();
        headers.set("token", this.session.getAccessToken());
        final Map<String, Object> map = new HashMap<>();
        final HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        // final HorarioComercialFestivoDocDto[] response = RestUtils.checkResponse(this.slrhorcomsClient
        // .exchange(url.toString(), HttpMethod.GET, entity,
        // HorarioComercialFestivoDocDto[].class),
        // this.slrhorcomsClient,
        // properties.getEndpoint(), request);
        // TODO [javierev] reactivar el servicio de festivos
        final HorarioComercialFestivoDocDto[] response = new HorarioComercialFestivoDocDto[0];

        request.setHasNext(response.length == request.getRows());
        request.setStart(request.getStart() + request.getRows());

        return Arrays.asList(response);
    }

    private void checkSession() {
        if (this.session != null) {
            final LocalDateTime now = TimeUtils.nowLocalDateTime();
            if (now.isAfter(this.session.getCreationDate().plus(Duration.ofMillis(this.timeout)))) {
                // la sesion ha caducado
                this.session = this.authenticate();
            } else if (now.isAfter(this.session.getCreationDate().plus(Duration.ofMillis(this.refreshTimeout)))) {
                // la sesion esta a punto de caducar
                this.session = this.refresh();
            }
        } else {
            // nunca se ha llegado a crear la sesion
            this.session = this.authenticate();
        }
    }

    /**
     * Autentica.
     * @return informacion de la sesion
     */
    private AuthenticateDto authenticate() {
        final ResponseEntity<AuthenticateResponseDto> responseAuthenticate = this.slrhorcomsClient
            .postForEntity(this.slrhorcomsProperties
                .get(HorarioComercialPropertiesConstants.AUTHENTICATE)
                .getEndpoint(), null, AuthenticateResponseDto.class);
        this.log.info("responseAuthenticate: {}", responseAuthenticate);
        if (responseAuthenticate.getStatusCode().value() != HttpStatus.SC_OK) {
            throw new SlrhorcomsIcmclcwbException("Error en login slrhorcomsI");
        }
        return AuthenticateDto.builder()
            .message(responseAuthenticate.getBody().getMessage())
            .accessToken(responseAuthenticate.getHeaders().getFirst("access-token"))
            .refreshToken(responseAuthenticate.getHeaders().getFirst("refresh-token"))
            .creationDate(TimeUtils.nowLocalDateTime())
            .build();
    }

    /**
     * Refresca la sesion.
     * @return informacion de la sesion
     */
    private AuthenticateDto refresh() {
        final ResponseEntity<AuthenticateResponseDto> responseAuthenticate = this.slrhorcomsClient
            .postForEntity(this.slrhorcomsProperties
                .get(HorarioComercialPropertiesConstants.AUTHENTICATE_REFRESH)
                .getEndpoint(), null, AuthenticateResponseDto.class);
        if (responseAuthenticate.getStatusCode().value() != HttpStatus.SC_OK) {
            throw new SlrhorcomsIcmclcwbException("Error en refresh slrhorcomsI");
        }
        return AuthenticateDto.builder()
            .message(responseAuthenticate.getBody().getMessage())
            .accessToken(responseAuthenticate.getHeaders().getFirst("access-token"))
            .refreshToken(responseAuthenticate.getHeaders().getFirst("refresh-token"))
            .creationDate(TimeUtils.nowLocalDateTime())
            .build();
    }

}
