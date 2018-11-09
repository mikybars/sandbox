package com.inditex.rrhh.icmclcwb.api.meta4.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.poc.PocTiendaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesResultItemDto;

public interface Meta4SessionService {

	CompletableFuture<List<EmpleadosTiendaResultItemDto>> getEmpleadosTienda(
			EmpleadosTiendaRequestDto empleadosTiendaRequestDto) throws Exception;

	List<EmpleadosEstructuraResultItemDto> getEmpleadosEstructura(
			EmpleadosEstructuraRequestDto empleadosEstructuraRequest) throws Exception;

	List<ValoresCondicionesResultItemDto> getValoresCondiciones(ValoresCondicionesRequestDto valoresCondicionesRequest)
			throws Exception;

	List<EmpleadosTiendaResultItemDto> getEmpleadosTienda(TrabajoDto trabajo) throws Exception;

	List<PeriodoDto> periodo();

	List<PocTiendaDto> getTiendas(TrabajoDto trabajo);

}