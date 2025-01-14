package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoOrigenDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface ProgramacionAmbitoOrigenService {

  List<ProgramacionAmbitoOrigenDTO> create(
      @Valid @NonNull @NotEmpty final List<ProgramacionAmbitoOrigenDTO> programacionAmbitoOrigen,
      @NonNull final ProgramacionAmbitoDTO programacionAmbito);

  List<ProgramacionAmbitoOrigenDTO> findByProgramacionAmbito(
      @NonNull final ProgramacionAmbitoDTO programacionAmbito);

}
