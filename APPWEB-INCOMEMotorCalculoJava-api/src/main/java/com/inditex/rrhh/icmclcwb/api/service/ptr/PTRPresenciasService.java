package com.inditex.rrhh.icmclcwb.api.service.ptr;

import com.inditex.rrhh.icmclcwb.api.dto.ProductDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasDetalleResonseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasDetalleComisionableRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasTotalTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasTotalTiendaSeccionRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.TiposHorasRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasDetalleComisionableResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasTotalTiendaResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasTotalTiendaSeccionResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.TiposHorasResponseDTO;

public interface PTRPresenciasService {
	
	PresenciasDetalleResonseDTO PresenciasDetalle(final PresenciasDetalleRequestDTO presencias);
	
	PresenciasDetalleComisionableResponseDTO PresenciasDetalleComisionable(final PresenciasDetalleComisionableRequestDTO presencias);
	
	PresenciasTotalTiendaResponseDTO PresenciasTotalTienda(final PresenciasTotalTiendaRequestDTO presencias);
	
	PresenciasTotalTiendaSeccionResponseDTO PresenciasTotalTiendaSeccion(final PresenciasTotalTiendaSeccionRequestDTO presencias);
	
	TiposHorasResponseDTO findTiposHoras(final TiposHorasRequestDTO tiposHoras);

}
