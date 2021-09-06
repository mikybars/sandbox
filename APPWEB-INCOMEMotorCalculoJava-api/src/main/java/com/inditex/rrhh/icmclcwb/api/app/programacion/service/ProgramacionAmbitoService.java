package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;

public interface ProgramacionAmbitoService {

    List<ProgramacionAmbitoDto> create(@Valid @NotNull final List<ProgramacionAmbitoDto> programacionAmbito,
            @NotNull final ProgramacionDto programacion);

    List<ProgramacionAmbitoDTO> findByProgramacion(@NotNull final ProgramacionDTO programacion);

}
