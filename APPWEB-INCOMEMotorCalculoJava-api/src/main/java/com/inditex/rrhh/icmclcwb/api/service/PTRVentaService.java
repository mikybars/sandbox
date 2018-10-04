package com.inditex.rrhh.icmclcwb.api.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.ws.ptr.dto.venta.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ws.ptr.dto.venta.GetVentaTotalizadoResponseDTO;

public interface PTRVentaService {
	
	GetVentaTotalizadoResponseDTO getVentaTotalizado(@Valid final GetVentaTotalizadoRequestDTO getVentaTotalizadoRequest) throws Exception;
    
}