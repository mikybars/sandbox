package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service;

import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoResponseDto;

public interface Meta4IcmWsCalcIncomeService {

	TiendasEmpleadoResponseDto getTiendasEmpleado(TiendasEmpleadoRequestDto request) throws Exception;
	
}