package com.inditex.rrhh.icmclcwb.api.service.ptr;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasDetalleResponseDTO;

public interface PTRPresenciasService {

	PresenciasDetalleResponseDTO getPresenciaDetalle(@Valid final PresenciasDetalleRequestDTO presencias) throws Exception;

	
}
