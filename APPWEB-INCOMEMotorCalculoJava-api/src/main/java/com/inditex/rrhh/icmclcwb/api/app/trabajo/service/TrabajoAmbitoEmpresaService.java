package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TrabajoAmbitoEmpresaService {

    List<TrabajoAmbitoEmpresaDto> findByTrabajo(@Valid @NotNull final TrabajoDto trabajo);

    List<TrabajoAmbitoEmpresaDto> create(
            @Valid @NotNull @NotEmpty final List<TrabajoAmbitoEmpresaDto> programacionAmbitoEmpresa,
            @NotNull final TrabajoDto trabajo);

}
