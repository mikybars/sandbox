package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstadoDto;

public interface TrabajoEmpleadoEstadoService {
	
	List<TrabajoEmpleadoEstadoDto> save(@Valid final List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado);
	
	List<TrabajoEmpleadoEstadoDto> save(@Valid final List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado, @Valid final TrabajoDto trabajo);

}
