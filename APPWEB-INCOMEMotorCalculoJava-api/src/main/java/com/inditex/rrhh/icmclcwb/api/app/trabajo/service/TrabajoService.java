package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TrabajoService {

    TrabajoDto findById(@NotNull @Positive final Long id);
    
	TrabajoDto createTrabajo(@Valid final TrabajoDto trabajo);

	TrabajoDto modifyTrabajo(@Valid final TrabajoDto trabajo);

	TrabajoDto modifyEstadoTrabajo(@Valid final TrabajoDto trabajo, @Valid final EstadoTrabajoDto estado);

}