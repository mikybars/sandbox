package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoLocalizacionDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TrabajoAmbitoLocalizacionService {

  List<TrabajoAmbitoLocalizacionDTO> findByTrabajo(@Valid @NonNull final TrabajoDTO trabajo);

  List<TrabajoAmbitoLocalizacionDTO> create(
      @Valid @NonNull @NotEmpty final List<TrabajoAmbitoLocalizacionDTO> programacionAmbitoLocalizacion,
      @NonNull final TrabajoDTO trabajo);

}
