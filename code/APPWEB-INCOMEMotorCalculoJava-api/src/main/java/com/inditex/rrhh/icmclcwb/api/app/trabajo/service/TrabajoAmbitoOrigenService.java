package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoOrigenDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TrabajoAmbitoOrigenService {

  List<TrabajoAmbitoOrigenDTO> findByTrabajo(@Valid @NonNull final TrabajoDTO trabajo);

  List<TrabajoAmbitoOrigenDTO> create(
      @Valid @NonNull @NotEmpty final List<TrabajoAmbitoOrigenDTO> programacionAmbitoOrigen,
      @NonNull final TrabajoDTO trabajo);

}
