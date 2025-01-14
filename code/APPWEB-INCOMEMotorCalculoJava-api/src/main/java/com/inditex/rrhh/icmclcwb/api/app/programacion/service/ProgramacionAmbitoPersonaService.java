package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoPersonaDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface ProgramacionAmbitoPersonaService {

  List<ProgramacionAmbitoPersonaDTO> create(
      @Valid @NonNull @NotEmpty final List<ProgramacionAmbitoPersonaDTO> programacionAmbitoPersona,
      @NonNull final ProgramacionAmbitoDTO programacionAmbito);

  List<ProgramacionAmbitoPersonaDTO> findByProgramacionAmbito(
      @NonNull final ProgramacionAmbitoDTO programacionAmbito);

}
