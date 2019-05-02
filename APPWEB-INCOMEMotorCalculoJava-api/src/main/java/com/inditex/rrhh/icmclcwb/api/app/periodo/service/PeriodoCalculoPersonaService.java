package com.inditex.rrhh.icmclcwb.api.app.periodo.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.PeriodoCalculoPersonaDto;

public interface PeriodoCalculoPersonaService {

    List<PeriodoCalculoPersonaDto> save(@Valid final List<PeriodoCalculoPersonaDto> src);

}
