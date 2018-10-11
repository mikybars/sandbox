package com.inditex.rrhh.icmclcwb.api.app.service;

import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaResponseDTO;

public interface Meta4IcmWsIncomeService {
    
	GetEmpleadosTiendaResponseDTO obtenerEmpleadosTienda(GetEmpleadosTiendaRequestDTO getEmpleadosTiendaRequestDTO) throws Exception;
	
}