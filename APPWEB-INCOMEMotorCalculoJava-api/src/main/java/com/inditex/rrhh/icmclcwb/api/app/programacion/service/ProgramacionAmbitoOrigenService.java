package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoOrigenDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface ProgramacionAmbitoOrigenService {

  List<ProgramacionAmbitoOrigenDTO> create(
      @Valid @NotNull @NotEmpty final List<ProgramacionAmbitoOrigenDTO> programacionAmbitoOrigen,
      @NotNull final ProgramacionAmbitoDTO programacionAmbito);

  List<ProgramacionAmbitoOrigenDTO> findByProgramacionAmbito(
      @NotNull final ProgramacionAmbitoDTO programacionAmbito);

}
