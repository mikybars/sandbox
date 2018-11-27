package com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciasDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciasDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciasDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciasTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciasTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciasTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciasTotalTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciasTotalTiendaSeccionResultItemDto;

public interface PtrPresenciaMockService {

	List<PtrPresenciasDetalleResultItemDto> presenciasDetalle(final PtrPresenciasDetalleRequestDto request);

	List<PtrPresenciasDetalleComisionableResultItemDto> presenciasDetalleComisionable(
			final PtrPresenciasDetalleComisionableRequestDto request);

	List<PtrPresenciasTotalTiendaResultItemDto> presenciasTotalTienda(final PtrPresenciasTotalTiendaRequestDto request);

	List<PtrPresenciasTotalTiendaSeccionResultItemDto> presenciasTotalTiendaSeccion(
			final PtrPresenciasTotalTiendaSeccionRequestDto request);

	List<PtrPresenciasTiposHorasResultItemDto> tiposHoras(final PtrPresenciasTiposHorasRequestDto request);

}