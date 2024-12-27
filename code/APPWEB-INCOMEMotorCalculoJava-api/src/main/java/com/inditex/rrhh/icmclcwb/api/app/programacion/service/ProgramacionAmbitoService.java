package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface ProgramacionAmbitoService {

  List<ProgramacionAmbitoDTO> create(@Valid @NonNull final List<ProgramacionAmbitoDTO> programacionAmbito,
      @NonNull final ProgramacionDTO programacion);

  List<ProgramacionAmbitoDTO> findByProgramacion(@NonNull final ProgramacionDTO programacion);

}
