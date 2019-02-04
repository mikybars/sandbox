package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoEstadoDto;

public interface TrabajoEmpleadoEstadoService {
	
	List<TrabajoEmpleadoEstadoDto> save(@Valid final List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado) throws Exception;
	
    List<TrabajoEmpleadoEstadoDto> save(@Valid final List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado, @Valid final TrabajoDto trabajo) throws Exception;
	
	List<String> findIdsEmpleadoByIdTrabajoAndIdEstado(final Long idTrabajo, final Long idEstado);
	
}
