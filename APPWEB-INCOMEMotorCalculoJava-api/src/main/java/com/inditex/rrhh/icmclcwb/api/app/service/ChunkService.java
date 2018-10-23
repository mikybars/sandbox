package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraRequestDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesRequestDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoResponseDTO;

public interface ChunkService {
    
	CompletableFuture<GetVentaTotalizadoResponseDTO> getVentaTotalizado(@Valid final GetVentaTotalizadoRequestDTO getVentaTotalizadoRequest);

	CompletableFuture<List<EmpleadosTiendaResultItemDTO>> getEmpleadosTienda(@Valid EmpleadosTiendaRequestDTO request);

	CompletableFuture<List<EmpleadosEstructuraResultItemDTO>> getEmpleadosEstructura(
			@Valid EmpleadosEstructuraRequestDTO request);

	CompletableFuture<List<ValoresCondicionesResultItemDTO>> getValoresCondiciones(
			@Valid ValoresCondicionesRequestDTO request);

	CompletableFuture<List<EmpleadosTiendaResultItemDTO>> getEmpleadosTienda(TrabajoDto trabajo);
	
}