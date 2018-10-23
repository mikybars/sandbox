package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDto;

public interface TrabajoService {

	TrabajoDto createTrabajo(@Valid final TrabajoDto trabajo);

	TrabajoRunDto run(final Long id) throws Exception;

}