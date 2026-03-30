package com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.service;

/*
 * Copyright (c) 2021. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.dto.ResponseDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;

public interface IOPComercialCalendarService {

  ResponseDto<HorarioComercialFestivoDocDto> horarioComercialFestivos(
      HorarioComercialFestivosRequestDto request);

}
