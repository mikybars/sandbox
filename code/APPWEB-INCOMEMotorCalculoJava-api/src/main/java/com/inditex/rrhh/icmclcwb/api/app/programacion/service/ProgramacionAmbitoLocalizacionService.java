package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoLocalizacionDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface ProgramacionAmbitoLocalizacionService {

  List<ProgramacionAmbitoLocalizacionDTO> create(
      @Valid @NonNull @NotEmpty final List<ProgramacionAmbitoLocalizacionDTO> programacionAmbitoLocalizacion,
      @NonNull final ProgramacionAmbitoDTO programacionAmbito);

  List<ProgramacionAmbitoLocalizacionDTO> findByProgramacionAmbito(
      @NonNull final ProgramacionAmbitoDTO programacionAmbito);

}
