package com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.TiposHorasResponseDto;

public interface PtrPresenciaMockService {

	List<PresenciasDetalleResponseDto> presenciasDetalle(final PresenciasDetalleRequestDto request);

	List<PresenciasDetalleComisionableResponseDto> presenciasDetalleComisionable(
			final PresenciasDetalleComisionableRequestDto request);

	List<PresenciasTotalTiendaResponseDto> presenciasTotalTienda(final PresenciasTotalTiendaRequestDto request);

	List<PresenciasTotalTiendaSeccionResponseDto> presenciasTotalTiendaSeccion(
			final PresenciasTotalTiendaSeccionRequestDto request);

	List<TiposHorasResponseDto> tiposHoras(final TiposHorasRequestDto request);

}