package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TrabajoAmbitoOrigenService {

    List<TrabajoAmbitoOrigenDto> findByTrabajo(@Valid @NotNull final TrabajoDto trabajo);

    List<TrabajoAmbitoOrigenDto> create(
            @Valid @NotNull @NotEmpty final List<TrabajoAmbitoOrigenDto> programacionAmbitoOrigen,
            @NotNull final TrabajoDto trabajo);

}
