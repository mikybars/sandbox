package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.Valid;
import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface TrabajoService {

	TrabajoDto createTrabajo(@Valid final TrabajoDto trabajo);

	TrabajoDto modifyTrabajo(@Valid final TrabajoDto trabajo);

	TrabajoDto modifyEstadoTrabajo(@Valid final EstadoTrabajoDto estado, @Valid final TrabajoDto trabajo);

}