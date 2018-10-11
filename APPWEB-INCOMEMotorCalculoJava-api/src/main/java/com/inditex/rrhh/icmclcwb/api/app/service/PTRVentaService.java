package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoResponseDTO;

public interface PTRVentaService {
	
	GetVentaTotalizadoResponseDTO getVentaTotalizado(@Valid final GetVentaTotalizadoRequestDTO getVentaTotalizadoRequest) throws Exception;
    
}