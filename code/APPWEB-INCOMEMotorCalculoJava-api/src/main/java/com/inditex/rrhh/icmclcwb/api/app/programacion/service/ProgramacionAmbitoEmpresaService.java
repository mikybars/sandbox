package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoEmpresaDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface ProgramacionAmbitoEmpresaService {

  List<ProgramacionAmbitoEmpresaDTO> create(
      @Valid @NonNull @NotEmpty final List<ProgramacionAmbitoEmpresaDTO> programacionAmbitoEmpresa,
      @NonNull final ProgramacionAmbitoDTO programacionAmbito);

  List<ProgramacionAmbitoEmpresaDTO> findByProgramacionAmbito(
      @NonNull final ProgramacionAmbitoDTO programacionAmbito);

}
