package com.inditex.rrhh.icmclcwb.api.app.periodo.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.PeriodoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface PeriodoPersonaService {

    List<PeriodoPersonaDto> save(@Valid final List<PeriodoPersonaDto> src);

    void mergePeriodoPersona(@NotNull final RunTareaDto tareaDto);

}
