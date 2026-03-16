package com.inditex.rrhh.icmclcwb.model.iopcomercialcalendar.service;

/*
 * Copyright (c) 2021. Inditex
 */

import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.HORARIO_COMERCIAL_FESTIVOS;

import java.util.Arrays;
import java.util.Map;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.dto.IopcomercialcalendarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.dto.ResponseDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.exception.IopcomercialcalendarIcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.service.IOPComercialCalendarService;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.util.HorarioComercialPropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.RestUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class IOPComercialCalendarCalendarServiceImpl implements IOPComercialCalendarService {

  private static final Logger LOG = LoggerFactory.getLogger(IOPComercialCalendarCalendarServiceImpl.class);

  @Autowired
  @Qualifier("iopcomercialcalendarClient")
  private RestClient iopcomercialcalendarClient;

  @Autowired
  @Qualifier("iopcomercialcalendarProperties")
  private Map<String, IopcomercialcalendarPropertiesDto> iopcomercialcalendarProperties;

  @Autowired
  private TareaMapper tareaMapper;

  @Override
  @Retryable(maxAttemptsExpression = "${app.envars.iopcomercialcalendar.config.max-attempts}")
  @Cacheable(value = HORARIO_COMERCIAL_FESTIVOS, key = "#request")
  public ResponseDto<HorarioComercialFestivoDocDto> horarioComercialFestivos(
      final HorarioComercialFestivosRequestDto request) {

    final IopcomercialcalendarPropertiesDto properties = this.iopcomercialcalendarProperties
        .get(HorarioComercialPropertiesConstants.HORARIO_COMERCIAL_FESTIVO);
    final String query = this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request);
    final StringBuilder url = new StringBuilder()
        .append(properties.getEndpoint())
        .append(query);
    try {
      final HorarioComercialFestivoDocDto[] response = RestUtils.checkResponse(this.iopcomercialcalendarClient
          .getForEntity(url.toString(), HorarioComercialFestivoDocDto[].class),
          this.iopcomercialcalendarClient,
          properties.getEndpoint(), request);

      final ResponseDto<HorarioComercialFestivoDocDto> result = new ResponseDto<>();
      result.setData(Arrays.asList(response));
      return result;
    } catch (final Exception e) {
      throw new IopcomercialcalendarIcmclcwbException("Error en cliente iopcomercialcalendar [url: " + url + "]", e);
    }
  }

}
