package com.inditex.rrhh.icmclcwb.api.app.service;

import com.inditex.rrhh.icmclcwb.api.meta4.empleadosestructura.dto.EmpleadosEstructuraRequestDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadosestructura.dto.EmpleadosEstructuraResponseDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadostienda.dto.EmpleadosTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadostienda.dto.EmpleadosTiendaResponseDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.valorescondiciones.dto.ValoresCondicionesRequestDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.valorescondiciones.dto.ValoresCondicionesResponseDTO;

public interface Meta4IcmWsIncomeService {
    
	EmpleadosTiendaResponseDTO getEmpleadosTienda(EmpleadosTiendaRequestDTO getEmpleadosTiendaRequestDTO)
			throws Exception;
	
	EmpleadosEstructuraResponseDTO getEmpleadosEstructura(EmpleadosEstructuraRequestDTO empleadosEstructuraRequestDTO)
			throws Exception;

	ValoresCondicionesResponseDTO getValoresCondiciones(ValoresCondicionesRequestDTO valoresCondicionesRequestDTO)
			throws Exception;	
	
}