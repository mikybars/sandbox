package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoEmpresaDto;

public interface ProgramacionAmbitoEmpresaService {

    List<ProgramacionAmbitoEmpresaDto> create(
            @Valid @NotNull @NotEmpty final List<ProgramacionAmbitoEmpresaDto> programacionAmbitoEmpresa,
            @NotNull final ProgramacionAmbitoDto programacionAmbito);

    List<ProgramacionAmbitoEmpresaDto> findByProgramacionAmbito(
            @NotNull final ProgramacionAmbitoDto programacionAmbito);
    
}
