package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoResultItemDto;

public interface Meta4IcmWsCalcIncomeSessionService {

	List<TiendasEmpleadoResultItemDto> getTiendasEmpleado(TiendasEmpleadoRequestDto request) throws Exception;

}