package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoOrigenDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface TrabajoAmbitoOrigenService {

  List<TrabajoAmbitoOrigenDTO> findByTrabajo(@Valid @NotNull final TrabajoDTO trabajo);

  List<TrabajoAmbitoOrigenDTO> create(
      @Valid @NotNull @NotEmpty final List<TrabajoAmbitoOrigenDTO> programacionAmbitoOrigen,
      @NotNull final TrabajoDTO trabajo);

}
