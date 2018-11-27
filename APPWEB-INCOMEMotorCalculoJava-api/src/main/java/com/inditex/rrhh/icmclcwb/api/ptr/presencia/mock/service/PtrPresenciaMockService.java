package com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;

public interface PtrPresenciaMockService {

	List<PtrPresenciaDetalleResultItemDto> presenciasDetalle(final PtrPresenciaDetalleRequestDto request);

	List<PtrPresenciaDetalleComisionableResultItemDto> presenciasDetalleComisionable(
			final PtrPresenciaDetalleComisionableRequestDto request);

	List<PtrPresenciaTotalTiendaResultItemDto> presenciasTotalTienda(final PtrPresenciaTotalTiendaRequestDto request);

	List<PtrPresenciaTotalTiendaSeccionResultItemDto> presenciasTotalTiendaSeccion(
			final PtrPresenciaTotalTiendaSeccionRequestDto request);

	List<PtrPresenciaTiposHorasResultItemDto> tiposHoras(final PtrPresenciaTiposHorasRequestDto request);

}