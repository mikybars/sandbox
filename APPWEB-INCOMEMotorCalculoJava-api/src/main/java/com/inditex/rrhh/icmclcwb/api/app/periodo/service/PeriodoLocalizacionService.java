package com.inditex.rrhh.icmclcwb.api.app.periodo.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.PeriodoLocalizacionDto;

public interface PeriodoLocalizacionService {

    List<PeriodoLocalizacionDto> save(@Valid final List<PeriodoLocalizacionDto> src);

}
