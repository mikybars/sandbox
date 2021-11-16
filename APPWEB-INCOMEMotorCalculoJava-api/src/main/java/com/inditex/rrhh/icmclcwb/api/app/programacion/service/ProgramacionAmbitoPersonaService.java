package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoPersonaDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface ProgramacionAmbitoPersonaService {

  List<ProgramacionAmbitoPersonaDTO> create(
      @Valid @NotNull @NotEmpty final List<ProgramacionAmbitoPersonaDTO> programacionAmbitoPersona,
      @NotNull final ProgramacionAmbitoDTO programacionAmbito);

  List<ProgramacionAmbitoPersonaDTO> findByProgramacionAmbito(
      @NotNull final ProgramacionAmbitoDTO programacionAmbito);

}
