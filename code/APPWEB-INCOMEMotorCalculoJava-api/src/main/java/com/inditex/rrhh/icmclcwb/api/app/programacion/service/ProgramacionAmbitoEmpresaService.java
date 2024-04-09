package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoEmpresaDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public interface ProgramacionAmbitoEmpresaService {

  List<ProgramacionAmbitoEmpresaDTO> create(
      @Valid @NotNull @NotEmpty final List<ProgramacionAmbitoEmpresaDTO> programacionAmbitoEmpresa,
      @NotNull final ProgramacionAmbitoDTO programacionAmbito);

  List<ProgramacionAmbitoEmpresaDTO> findByProgramacionAmbito(
      @NotNull final ProgramacionAmbitoDTO programacionAmbito);

}
