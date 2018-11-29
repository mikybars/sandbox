package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleados.dto.EmpleadosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchempleados.dto.SearchEmpleadosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchtiendas.dto.SearchTiendasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendas.dto.TiendasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoResultItemDto;

public interface Meta4IcmWsCalcIncomeSessionService {

	List<TiendasEmpleadoResultItemDto> getTiendasEmpleado(TiendasEmpleadoRequestDto request) throws Exception;

	List<SearchTiendasResultItemDto> searchTiendas(SearchTiendasRequestDto request) throws Exception;

	List<TiendasResultItemDto> getTiendas(TiendasRequestDto request) throws Exception;

	List<SearchEmpleadosResultItemDto> searchEmpleados(SearchEmpleadosRequestDto request) throws Exception;

	List<GenericEmpleadoResultItemDto> getComisionEmpleado(ComisionEmpleadoRequestDto request) throws Exception;

	List<EmpleadosResultItemDto> getEmpleados(EmpleadosRequestDto request) throws Exception;

}