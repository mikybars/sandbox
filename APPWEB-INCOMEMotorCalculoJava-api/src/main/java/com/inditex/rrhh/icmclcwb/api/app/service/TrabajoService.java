package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.Valid;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface TrabajoService {

	TrabajoDto createTrabajo(@Valid final TrabajoDto trabajo);

	TrabajoDto run(@NotNull @NegativeOrZero final Long id) throws Exception;
	
	TrabajoDto runTrabajo(@Valid final TrabajoDto trabajo) throws Exception;
	
	TrabajoDto modifyTrabajo(@Valid final TrabajoDto trabajo);
	
	TrabajoDto modifyEstadoTrabajo(@NotNull @NegativeOrZero final Long id, @Valid final TrabajoDto trabajo);
	
}