package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoLocalizacionDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface ProgramacionAmbitoLocalizacionService {

  List<ProgramacionAmbitoLocalizacionDTO> create(
      @Valid @NotNull @NotEmpty final List<ProgramacionAmbitoLocalizacionDTO> programacionAmbitoLocalizacion,
      @NotNull final ProgramacionAmbitoDTO programacionAmbito);

  List<ProgramacionAmbitoLocalizacionDTO> findByProgramacionAmbito(
      @NotNull final ProgramacionAmbitoDTO programacionAmbito);

}
