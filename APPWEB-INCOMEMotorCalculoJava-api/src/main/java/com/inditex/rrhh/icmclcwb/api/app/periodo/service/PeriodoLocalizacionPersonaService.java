package com.inditex.rrhh.icmclcwb.api.app.periodo.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.PeriodoLocalizacionPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface PeriodoLocalizacionPersonaService {

    List<PeriodoLocalizacionPersonaDto> save(@Valid List<PeriodoLocalizacionPersonaDto> src);

    void mergePeriodoLocalizacionPersona(@NotNull final RunTareaDto tareaDto);

}
