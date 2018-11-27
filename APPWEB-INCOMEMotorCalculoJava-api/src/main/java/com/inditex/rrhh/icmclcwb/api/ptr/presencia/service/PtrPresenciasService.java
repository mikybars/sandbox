package com.inditex.rrhh.icmclcwb.api.ptr.presencia.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTotalTiendaSeccionResponseDto;

public interface PtrPresenciasService {

    PtrPresenciasMockTotalTiendaSeccionResponseDto getPresenciasTotalTiendaSeccionDto(
            @Valid PtrPresenciasMockTotalTiendaSeccionRequestDto request) throws Exception;

    PtrPresenciasMockDetalleResponseDto getPresenciasDetalleDto(@Valid PtrPresenciasMockDetalleRequestDto request) throws Exception;

}
