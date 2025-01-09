package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoPersonaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TrabajoAmbitoPersonaService {

  List<TrabajoAmbitoPersonaDTO> findByTrabajo(@Valid @NonNull final TrabajoDTO trabajo);

  List<TrabajoAmbitoPersonaDTO> create(
      @Valid @NonNull @NotEmpty final List<TrabajoAmbitoPersonaDTO> programacionAmbitoPersona,
      @NonNull final TrabajoDTO trabajo);

}
