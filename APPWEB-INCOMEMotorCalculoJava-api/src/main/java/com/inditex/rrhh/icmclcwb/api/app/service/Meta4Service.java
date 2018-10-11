package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaResultItemDTO;

public interface Meta4Service {
	
	List<GetEmpleadosTiendaResultItemDTO> obtenerEmpleadosTienda(String idTienda) throws Exception;
    
}