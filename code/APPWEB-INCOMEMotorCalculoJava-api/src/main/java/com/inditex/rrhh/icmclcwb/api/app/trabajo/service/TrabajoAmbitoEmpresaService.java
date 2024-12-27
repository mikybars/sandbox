package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoEmpresaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TrabajoAmbitoEmpresaService {

  List<TrabajoAmbitoEmpresaDTO> findByTrabajo(@Valid @NonNull final TrabajoDTO trabajo);

  List<TrabajoAmbitoEmpresaDTO> create(
      @Valid @NonNull @NotEmpty final List<TrabajoAmbitoEmpresaDTO> programacionAmbitoEmpresa,
      @NonNull final TrabajoDTO trabajo);

}
