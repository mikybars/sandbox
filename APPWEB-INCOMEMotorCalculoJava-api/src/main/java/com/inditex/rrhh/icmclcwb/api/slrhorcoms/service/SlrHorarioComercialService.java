package com.inditex.rrhh.icmclcwb.api.slrhorcoms.service;

/*
 * Copyright (c) 2021. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.ResponseDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;

public interface SlrHorarioComercialService {

  ResponseDto<HorarioComercialFestivoDocDto> horarioComercialFestivos(
      HorarioComercialFestivosRequestDto request);

}
