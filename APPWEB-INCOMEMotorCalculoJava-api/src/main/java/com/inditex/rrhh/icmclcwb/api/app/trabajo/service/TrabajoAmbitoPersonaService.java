package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoPersonaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface TrabajoAmbitoPersonaService {

  List<TrabajoAmbitoPersonaDTO> findByTrabajo(@Valid @NotNull final TrabajoDTO trabajo);

  List<TrabajoAmbitoPersonaDTO> create(
      @Valid @NotNull @NotEmpty final List<TrabajoAmbitoPersonaDTO> programacionAmbitoPersona,
      @NotNull final TrabajoDTO trabajo);

}
