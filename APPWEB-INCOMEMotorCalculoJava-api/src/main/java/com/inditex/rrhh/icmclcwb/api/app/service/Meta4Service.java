package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.JobDto;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadosestructura.dto.EmpleadosEstructuraRequestDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadosestructura.dto.EmpleadosEstructuraResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadostienda.dto.EmpleadosTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadostienda.dto.EmpleadosTiendaResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.valorescondiciones.dto.ValoresCondicionesRequestDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.valorescondiciones.dto.ValoresCondicionesResultItemDTO;

public interface Meta4Service {
	
	List<EmpleadosTiendaResultItemDTO> getEmpleadosTienda(
			EmpleadosTiendaRequestDTO request) throws Exception;

	List<EmpleadosEstructuraResultItemDTO> getEmpleadosEstructura(EmpleadosEstructuraRequestDTO request)
			throws Exception;

	List<ValoresCondicionesResultItemDTO> getValoresCondiciones(ValoresCondicionesRequestDTO request) throws Exception;

	List<EmpleadosTiendaResultItemDTO> getEmpleadosTienda(JobDto request) throws Exception;
    
}