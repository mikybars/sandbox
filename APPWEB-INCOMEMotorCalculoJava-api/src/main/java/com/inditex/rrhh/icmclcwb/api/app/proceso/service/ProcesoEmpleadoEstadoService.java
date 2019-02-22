package com.inditex.rrhh.icmclcwb.api.app.proceso.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoEstadoDto;

public interface ProcesoEmpleadoEstadoService {
	
	List<ProcesoEmpleadoEstadoDto> save(@Valid final List<ProcesoEmpleadoEstadoDto> procesoEmpleadoEstado);
	
    List<ProcesoEmpleadoEstadoDto> save(@Valid final List<ProcesoEmpleadoEstadoDto> procesoEmpleadoEstado, @Valid final ProcesoDto proceso);
	
	List<String> findIdsEmpleadoByIdProcesoAndIdEstado(final Long idProceso, final Long idEstado);
	
}
