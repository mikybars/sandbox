package com.inditex.rrhh.icmclcwb.api.service;

import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaRequestDTO;

public interface Meta4IcmWsIncomeService {
    
	boolean obtenerEmpleadosTienda(GetEmpleadosTiendaRequestDTO getEmpleadosTiendaRequestDTO) throws Exception;
	
}