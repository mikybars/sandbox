package com.inditex.rrhh.icmclcwb.api.service.ptr;

import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasDetalleResponseDTO;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasDetalleComisionableRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasTotalTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasTotalTiendaSeccionRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.TiposHorasRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasDetalleComisionableResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasTotalTiendaResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasTotalTiendaSeccionResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.TiposHorasResponseDTO;

public interface PTRPresenciasServiceMock {
	
	List<PresenciasDetalleResponseDTO> PresenciasDetalle(final PresenciasDetalleRequestDTO presencias);
	
	List<PresenciasDetalleComisionableResponseDTO> PresenciasDetalleComisionable(final PresenciasDetalleComisionableRequestDTO presencias);
	
	List<PresenciasTotalTiendaResponseDTO> PresenciasTotalTienda(final PresenciasTotalTiendaRequestDTO presencias);
	
	List<PresenciasTotalTiendaSeccionResponseDTO> PresenciasTotalTiendaSeccion(final PresenciasTotalTiendaSeccionRequestDTO presencias);
	
	List<TiposHorasResponseDTO> TiposHoras(final TiposHorasRequestDTO tiposHoras);

}
