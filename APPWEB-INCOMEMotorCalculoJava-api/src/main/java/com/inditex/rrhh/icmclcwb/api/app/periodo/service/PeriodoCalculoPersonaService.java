package com.inditex.rrhh.icmclcwb.api.app.periodo.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.PeriodoCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface PeriodoCalculoPersonaService {

    List<PeriodoCalculoPersonaDto> save(@Valid final List<PeriodoCalculoPersonaDto> src);

    void mergePeriodoCalculoPersona(@NotNull final RunTareaDto tareaDto);

}
