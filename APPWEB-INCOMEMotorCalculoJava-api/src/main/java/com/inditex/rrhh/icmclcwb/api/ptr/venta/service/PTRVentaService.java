package com.inditex.rrhh.icmclcwb.api.ptr.venta.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaIndividualDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaIndividualDetalleResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoResponseDTO;

public interface PTRVentaService {
	
	CompletableFuture<GetVentaTotalizadoResponseDTO> getVentaTotalizado(@Valid final GetVentaTotalizadoRequestDTO getVentaTotalizadoRequest) throws Exception;

	CompletableFuture<GetVentaIndividualDetalleResponseDTO> getVentaIndividualDetalle(
			@Valid GetVentaIndividualDetalleRequestDTO getVentaIndividualDetalleRequestDto) throws Exception;
    
}