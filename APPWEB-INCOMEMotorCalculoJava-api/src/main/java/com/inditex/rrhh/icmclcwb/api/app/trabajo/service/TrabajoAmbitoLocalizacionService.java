package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoLocalizacionDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface TrabajoAmbitoLocalizacionService {

  List<TrabajoAmbitoLocalizacionDTO> findByTrabajo(@Valid @NotNull final TrabajoDTO trabajo);

  List<TrabajoAmbitoLocalizacionDTO> create(
      @Valid @NotNull @NotEmpty final List<TrabajoAmbitoLocalizacionDTO> programacionAmbitoLocalizacion,
      @NotNull final TrabajoDTO trabajo);

}
