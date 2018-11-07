package com.inditex.rrhh.icmclcwb.api.ptr.presencia.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleComisionableRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiposHorasRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleComisionableResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaSeccionResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.TiposHorasResponseDTO;

public interface PTRPresenciasServiceMock {
	
	List<PresenciasDetalleResponseDTO> PresenciasDetalle(final PresenciasDetalleRequestDTO presencias);
	
	List<PresenciasDetalleComisionableResponseDTO> PresenciasDetalleComisionable(final PresenciasDetalleComisionableRequestDTO presencias);
	
	List<PresenciasTotalTiendaResponseDTO> PresenciasTotalTienda(final PresenciasTotalTiendaRequestDTO presencias);
	
	List<PresenciasTotalTiendaSeccionResponseDTO> PresenciasTotalTiendaSeccion(final PresenciasTotalTiendaSeccionRequestDTO presencias);
	
	List<TiposHorasResponseDTO> TiposHoras(final TiposHorasRequestDTO tiposHoras);

}
