/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.slrhorcoms.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;

public interface SlrHorarioComercialService {

    List<HorarioComercialFestivoDocDto> horarioComercialFestivos(HorarioComercialFestivosRequestDto request);

}
