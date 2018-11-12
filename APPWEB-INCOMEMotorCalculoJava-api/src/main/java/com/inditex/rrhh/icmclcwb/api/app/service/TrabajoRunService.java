package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface TrabajoRunService {

	TrabajoDto run(@NotNull @Positive final Long id) throws Exception;

	TrabajoDto runTrabajo(@NotNull @Valid final TrabajoDto trabajo) throws Exception;

	TrabajoDto runTrabajoDatos(@Valid final TrabajoDto trabajo) throws Exception;

	TrabajoDto runTrabajoCalculado(@Valid final TrabajoDto trabajo) throws Exception;

	TrabajoDto runTrabajoConsolidacion(@Valid final TrabajoDto trabajo) throws Exception;

}