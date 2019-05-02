package com.inditex.rrhh.icmclcwb.api.app.periodo.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.PeriodoLocalizacionPersonaDto;

public interface PeriodoLocalizacionPersonaService {

    List<PeriodoLocalizacionPersonaDto> save(@Valid List<PeriodoLocalizacionPersonaDto> src);

}
