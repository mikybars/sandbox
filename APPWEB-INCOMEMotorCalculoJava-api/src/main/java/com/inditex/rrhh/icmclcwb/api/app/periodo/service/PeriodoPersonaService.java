package com.inditex.rrhh.icmclcwb.api.app.periodo.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.PeriodoPersonaDto;

public interface PeriodoPersonaService {

    List<PeriodoPersonaDto> save(@Valid final List<PeriodoPersonaDto> src);

}
