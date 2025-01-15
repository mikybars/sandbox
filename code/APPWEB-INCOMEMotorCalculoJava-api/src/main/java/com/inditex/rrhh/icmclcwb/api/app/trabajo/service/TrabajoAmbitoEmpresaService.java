package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoEmpresaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public interface TrabajoAmbitoEmpresaService {

  List<TrabajoAmbitoEmpresaDTO> findByTrabajo(@Valid @NotNull final TrabajoDTO trabajo);

  List<TrabajoAmbitoEmpresaDTO> create(
      @Valid @NotNull @NotEmpty final List<TrabajoAmbitoEmpresaDTO> programacionAmbitoEmpresa,
      @NotNull final TrabajoDTO trabajo);

}
