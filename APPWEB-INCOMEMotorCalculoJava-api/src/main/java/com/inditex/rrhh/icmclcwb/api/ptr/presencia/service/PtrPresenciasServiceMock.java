package com.inditex.rrhh.icmclcwb.api.ptr.presencia.service;

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

public interface PtrPresenciasServiceMock {

	List<PresenciasDetalleResponseDto> presenciasDetalle(final PresenciasDetalleRequestDto presencias);

	List<PresenciasDetalleComisionableResponseDto> presenciasDetalleComisionable(
			final PresenciasDetalleComisionableRequestDto presencias);

	List<PresenciasTotalTiendaResponseDto> presenciasTotalTienda(final PresenciasTotalTiendaRequestDto presencias);

	List<PresenciasTotalTiendaSeccionResponseDto> presenciasTotalTiendaSeccion(
			final PresenciasTotalTiendaSeccionRequestDto presencias);

	List<TiposHorasResponseDto> tiposHoras(final TiposHorasRequestDto tiposHoras);

}