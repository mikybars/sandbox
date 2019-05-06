package com.inditex.rrhh.icmclcwb.api.app.periodo.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.PeriodoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface PeriodoLocalizacionService {

    List<PeriodoLocalizacionDto> save(@Valid final List<PeriodoLocalizacionDto> src);

    void mergePeriodoLocalizacion(@NotNull final RunTareaDto tareaDto);

}
