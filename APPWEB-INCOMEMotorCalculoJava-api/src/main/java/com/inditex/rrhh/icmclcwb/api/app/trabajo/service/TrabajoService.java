package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TrabajoService {

	TrabajoDto createTrabajo(@Valid final TrabajoDto trabajo);

	TrabajoDto modifyTrabajo(@Valid final TrabajoDto trabajo);

	TrabajoDto modifyEstadoTrabajo(@Valid final EstadoTrabajoDto estado, @Valid final TrabajoDto trabajo);

}