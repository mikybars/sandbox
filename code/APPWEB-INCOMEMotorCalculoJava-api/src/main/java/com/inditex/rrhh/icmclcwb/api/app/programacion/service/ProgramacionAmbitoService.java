package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface ProgramacionAmbitoService {

  List<ProgramacionAmbitoDTO> create(@Valid @NotNull final List<ProgramacionAmbitoDTO> programacionAmbito,
      @NotNull final ProgramacionDTO programacion);

  List<ProgramacionAmbitoDTO> findByProgramacion(@NotNull final ProgramacionDTO programacion);

}
