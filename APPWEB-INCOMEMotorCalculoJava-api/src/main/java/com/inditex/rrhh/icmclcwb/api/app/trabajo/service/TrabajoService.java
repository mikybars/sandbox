package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TrabajoService {

    TrabajoDto findTrabajo(@NotNull @Positive final Long id);
    
    List<TrabajoDto> findAllTrabajo();
    
	TrabajoDto createTrabajo(@Valid final TrabajoDto trabajo);

	TrabajoDto modifyTrabajo(@Valid final TrabajoDto trabajo);

	TrabajoDto modifyEstadoTrabajo(@Valid final TrabajoDto trabajo, @Valid final EstadoTrabajoDto estado);
	
	TrabajoDto modifyEstadoTrabajoInicial(@Valid final TrabajoDto trabajo, @Valid final EstadoTrabajoDto estado);
	
	TrabajoDto modifyEstadoTrabajoFinal(@Valid final TrabajoDto trabajo, @Valid final EstadoTrabajoDto estado);

}