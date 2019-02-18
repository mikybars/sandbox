package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstadoDto;

public interface TareaEmpleadoEstadoService {
	
	List<TareaEmpleadoEstadoDto> save(@Valid final List<TareaEmpleadoEstadoDto> tareaEmpleadoEstado);
	
    List<TareaEmpleadoEstadoDto> save(@Valid final List<TareaEmpleadoEstadoDto> tareaEmpleadoEstado, @Valid final TareaDto tarea);
	
	List<String> findIdsEmpleadoByIdTareaAndIdEstado(final Long idTarea, final Long idEstado);
	
}
