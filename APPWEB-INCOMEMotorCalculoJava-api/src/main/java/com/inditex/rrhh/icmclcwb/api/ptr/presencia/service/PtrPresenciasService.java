package com.inditex.rrhh.icmclcwb.api.ptr.presencia.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciasDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciasTotalTiendaSeccionResponseDto;

public interface PtrPresenciasService {

	PtrPresenciasTotalTiendaSeccionResponseDto getPresenciasTotalTiendaSeccionDto(
            @Valid PtrPresenciasTotalTiendaSeccionRequestDto request) throws Exception;

    PtrPresenciasDetalleResponseDto getPresenciasDetalleDto(@Valid PtrPresenciasDetalleRequestDto request) throws Exception;

}
