package com.inditex.rrhh.icmclcwb.model.slrhorcoms.service;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.Arrays;
import java.util.Map;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.ResponseDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.SlrhorcomsPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.exception.SlrhorcomsIcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.service.SlrHorarioComercialService;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.util.HorarioComercialPropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.RestUtils;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
  @Retryable(maxAttemptsExpression = "${app.envars.slrhorcoms.config.max-attempts}")
  @Cacheable(value = "itx.icmlcwb.horario_comercial_festivos", key = "#request")
  public ResponseDto<HorarioComercialFestivoDocDto> horarioComercialFestivos(
      final HorarioComercialFestivosRequestDto request) {

    final SlrhorcomsPropertiesDto properties = this.slrhorcomsProperties
        .get(HorarioComercialPropertiesConstants.HORARIO_COMERCIAL_FESTIVO);
    final String query = this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request);
    final StringBuilder url = new StringBuilder()
        .append(properties.getEndpoint())
        .append(query);
    try {
      final HorarioComercialFestivoDocDto[] response = RestUtils.checkResponse(this.slrhorcomsClient
          .getForEntity(url.toString(), HorarioComercialFestivoDocDto[].class),
          this.slrhorcomsClient,
          properties.getEndpoint(), request);

      final ResponseDto<HorarioComercialFestivoDocDto> result = new ResponseDto<>();
      result.setNext(request.getStart() + request.getRows());
      result.setDocs(Arrays.asList(response));
      result.setHasNext(response.length == request.getRows());
      return result;
    } catch (final Exception e) {
      throw new SlrhorcomsIcmclcwbException("Error en cliente slrhorcoms [url: " + url + "]", e);
    }
  }

}
