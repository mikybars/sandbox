package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service;

import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.comisionempleado.dto.ComisionEmpleadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.empleados.dto.EmpleadosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.searchempleados.dto.SearchEmpleadosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.searchtiendas.dto.SearchTiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.tiendas.dto.TiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.tiendasempleado.dto.TiendasEmpleadoResponseDto;

public interface Meta4IcmWsCalcIncomeService {

	TiendasEmpleadoResponseDto getTiendasEmpleado(TiendasEmpleadoRequestDto request) throws Exception;

	SearchTiendasResponseDto searchTiendas(SearchTiendasRequestDto request) throws Exception;

	TiendasResponseDto getTiendas(TiendasRequestDto request) throws Exception;

	SearchEmpleadosResponseDto searchEmpleados(SearchEmpleadosRequestDto request) throws Exception;

	ComisionEmpleadoResponseDto getComisionEmpleado(ComisionEmpleadoRequestDto request) throws Exception;

	EmpleadosResponseDto getEmpleados(EmpleadosRequestDto request) throws Exception;
	
}