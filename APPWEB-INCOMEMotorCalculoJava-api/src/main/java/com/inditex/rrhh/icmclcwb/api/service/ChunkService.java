package com.inditex.rrhh.icmclcwb.api.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.ws.ptr.dto.venta.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ws.ptr.dto.venta.GetVentaTotalizadoResponseDTO;

public interface ChunkService {
    
	CompletableFuture<List<GetEmpleadosTiendaResultItemDTO>> obtenerEmpleadosTienda(String idTienda);
	
	CompletableFuture<GetVentaTotalizadoResponseDTO> getVentaTotalizado(@Valid final GetVentaTotalizadoRequestDTO getVentaTotalizadoRequest);
	
}