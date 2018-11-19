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

public interface Meta4SessionAsyncService {

	CompletableFuture<List<EmpleadosTiendaResultItemDto>> getEmpleadosTienda(
			EmpleadosTiendaRequestDto request) throws Exception;

	CompletableFuture<List<EmpleadosEstructuraResultItemDto>> getEmpleadosEstructura(
			EmpleadosEstructuraRequestDto request) throws Exception;

	CompletableFuture<List<ValoresCondicionesResultItemDto>> getValoresCondiciones(ValoresCondicionesRequestDto request)
			throws Exception;

	CompletableFuture<List<PeriodoDto>> periodo();

	CompletableFuture<List<PocTiendaDto>> getTiendas(TrabajoDto trabajo);

}