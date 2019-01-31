package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.tiendasempleado.dto.TiendasEmpleadoRequestDto;

public interface Meta4IcmWsCalcIncomeSessionAsyncService {

	CompletableFuture<List<GenericTiendaResultItemDto>> getTiendasEmpleado(TiendasEmpleadoRequestDto request)
			throws Exception;

	CompletableFuture<List<GenericTiendaResultItemDto>> searchTiendas(SearchTiendasRequestDto request) throws Exception;

	CompletableFuture<List<GenericTiendaResultItemDto>> getTiendas(TiendasRequestDto request) throws Exception;

	CompletableFuture<List<GenericEmpleadoResultItemDto>> searchEmpleados(SearchEmpleadosRequestDto request)
			throws Exception;

	CompletableFuture<List<GenericEmpleadoResultItemDto>> getComisionEmpleado(ComisionEmpleadoRequestDto request)
			throws Exception;

	CompletableFuture<List<GenericEmpleadoResultItemDto>> getEmpleados(EmpleadosRequestDto request) throws Exception;

}