package com.inditex.rrhh.icmclcwb.api.ptr.presencia.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResponseDto;

public interface PtrPresenciaService {

    PtrPresenciaTotalTiendaSeccionResponseDto getPresenciasTotalTiendaSeccionDto(
            @Valid final PtrPresenciaTotalTiendaSeccionRequestDto request) throws Exception;

    PtrPresenciaDetalleResponseDto getPresenciasDetalleDto(@Valid final PtrPresenciaDetalleRequestDto request)
            throws Exception;

    PtrPresenciaTiposHorasResponseDto getTiposHorasDto(@Valid final PtrPresenciaTiposHorasRequestDto request)
            throws Exception;

}
