package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstadoDto;

public interface TrabajoEmpleadoEstadoService {

	TrabajoEmpleadoEstadoDto save(@Valid TrabajoEmpleadoEstadoDto trabajoEmpleadoEstado);
	
	List<TrabajoEmpleadoEstadoDto> save(@Valid List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado);

}
