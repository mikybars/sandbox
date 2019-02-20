package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoPersonaDto;

public interface ProgramacionAmbitoPersonaService {

    List<ProgramacionAmbitoPersonaDto> create(
            @Valid @NotNull @NotEmpty final List<ProgramacionAmbitoPersonaDto> programacionAmbitoPersona,
            @NotNull final ProgramacionAmbitoDto programacionAmbito);

}
