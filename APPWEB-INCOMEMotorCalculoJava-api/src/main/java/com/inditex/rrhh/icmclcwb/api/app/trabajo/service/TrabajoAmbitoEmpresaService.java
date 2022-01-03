package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoEmpresaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface TrabajoAmbitoEmpresaService {

  List<TrabajoAmbitoEmpresaDTO> findByTrabajo(@Valid @NotNull final TrabajoDTO trabajo);

  List<TrabajoAmbitoEmpresaDTO> create(
      @Valid @NotNull @NotEmpty final List<TrabajoAmbitoEmpresaDTO> programacionAmbitoEmpresa,
      @NotNull final TrabajoDTO trabajo);

}
