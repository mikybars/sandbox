package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;

public interface ProgramacionAmbitoService {

    List<ProgramacionAmbitoDto> create(@Valid @NotNull final List<ProgramacionAmbitoDto> programacionAmbito,
            @NotNull final ProgramacionDto programacion);

    List<ProgramacionAmbitoDto> findByProgramacion(@NotNull final ProgramacionDto programacion);

}
