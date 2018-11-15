package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.Valid;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface TrabajoRunDatosService {

	TrabajoDto run(@Valid final TrabajoDto trabajo) throws Exception;

}