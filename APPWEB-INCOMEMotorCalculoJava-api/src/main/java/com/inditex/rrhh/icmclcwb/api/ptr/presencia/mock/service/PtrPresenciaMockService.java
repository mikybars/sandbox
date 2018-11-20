package com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTotalTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTiposHorasResponseDto;

public interface PtrPresenciaMockService {

	List<PtrPresenciasMockDetalleResponseDto> presenciasDetalle(final PtrPresenciasMockDetalleRequestDto request);

	List<PtrPresenciasMockDetalleComisionableResponseDto> presenciasDetalleComisionable(
			final PtrPresenciasMockDetalleComisionableRequestDto request);

	List<PtrPresenciasMockTotalTiendaResponseDto> presenciasTotalTienda(final PtrPresenciasMockTotalTiendaRequestDto request);

	List<PtrPresenciasMockTotalTiendaSeccionResponseDto> presenciasTotalTiendaSeccion(
			final PtrPresenciasMockTotalTiendaSeccionRequestDto request);

	List<PtrPresenciasMockTiposHorasResponseDto> tiposHoras(final PtrPresenciasMockTiposHorasRequestDto request);

}