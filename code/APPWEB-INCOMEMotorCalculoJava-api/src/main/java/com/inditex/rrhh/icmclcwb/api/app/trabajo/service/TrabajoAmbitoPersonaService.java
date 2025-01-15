package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoPersonaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public interface TrabajoAmbitoPersonaService {

  List<TrabajoAmbitoPersonaDTO> findByTrabajo(@Valid @NotNull final TrabajoDTO trabajo);

  List<TrabajoAmbitoPersonaDTO> create(
      @Valid @NotNull @NotEmpty final List<TrabajoAmbitoPersonaDTO> programacionAmbitoPersona,
      @NotNull final TrabajoDTO trabajo);

}
