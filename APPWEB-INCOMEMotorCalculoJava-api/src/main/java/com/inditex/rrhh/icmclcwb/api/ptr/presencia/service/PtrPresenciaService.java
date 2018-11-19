package com.inditex.rrhh.icmclcwb.api.ptr.presencia.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaSeccionResponseDto;

public interface PtrPresenciaService {

    PresenciasTotalTiendaSeccionResponseDto getPresenciasTotalTiendaSeccionDto(
            @Valid PresenciasTotalTiendaSeccionRequestDto request) throws Exception;

    PresenciasDetalleResponseDto getPresenciasDetalleDto(@Valid PresenciasDetalleRequestDto request) throws Exception;

}
