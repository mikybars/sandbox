package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoLocalizacionDto;

public interface ProgramacionAmbitoLocalizacionService {

    List<ProgramacionAmbitoLocalizacionDto> create(
            @Valid @NotNull @NotEmpty final List<ProgramacionAmbitoLocalizacionDto> programacionAmbitoLocalizacion,
            @NotNull final ProgramacionAmbitoDto programacionAmbito);

    List<ProgramacionAmbitoLocalizacionDto> findByProgramacionAmbito(
            @NotNull final ProgramacionAmbitoDto programacionAmbito);

}
