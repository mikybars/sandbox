package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoOrigenDto;

public interface ProgramacionAmbitoOrigenService {

    List<ProgramacionAmbitoOrigenDto> create(
            @Valid @NotNull @NotEmpty final List<ProgramacionAmbitoOrigenDto> programacionAmbitoOrigen,
            @NotNull final ProgramacionAmbitoDto programacionAmbito);

    List<ProgramacionAmbitoOrigenDto> findByProgramacionAmbito(
            @NotNull final ProgramacionAmbitoDto programacionAmbito);

}
