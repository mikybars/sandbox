package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoEmpresaDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface ProgramacionAmbitoEmpresaService {

  List<ProgramacionAmbitoEmpresaDTO> create(
      @Valid @NotNull @NotEmpty final List<ProgramacionAmbitoEmpresaDTO> programacionAmbitoEmpresa,
      @NotNull final ProgramacionAmbitoDTO programacionAmbito);

  List<ProgramacionAmbitoEmpresaDTO> findByProgramacionAmbito(
      @NotNull final ProgramacionAmbitoDTO programacionAmbito);

}
