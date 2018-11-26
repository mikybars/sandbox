package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.service;

import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesResponseDto;

public interface Meta4IcmWsIncomeService {
    
	EmpleadosTiendaResponseDto getEmpleadosTienda(EmpleadosTiendaRequestDto request)
			throws Exception;
	
	EmpleadosEstructuraResponseDto getEmpleadosEstructura(EmpleadosEstructuraRequestDto request)
			throws Exception;

	ValoresCondicionesResponseDto getValoresCondiciones(ValoresCondicionesRequestDto request)
			throws Exception;	
	
}