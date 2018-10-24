package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface TrabajoService {

	TrabajoDto createTrabajo(@Valid final TrabajoDto trabajo);

	TrabajoDto run(@NotNull @Positive final Long id) throws Exception;
	
	TrabajoDto runTrabajo(@Valid final TrabajoDto trabajo) throws Exception;
	
	TrabajoDto modifyTrabajo(@Valid final TrabajoDto trabajo);
	
	TrabajoDto modifyEstadoTrabajo(@NotNull @Positive final Long id, @Valid final TrabajoDto trabajo);
	
}