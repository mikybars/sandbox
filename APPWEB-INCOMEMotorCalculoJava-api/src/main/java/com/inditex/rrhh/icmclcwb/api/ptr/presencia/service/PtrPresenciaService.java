package com.inditex.rrhh.icmclcwb.api.ptr.presencia.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResponseDto;

public interface PtrPresenciaService {

    PtrPresenciaTotalTiendaSeccionResponseDto getPresenciasTotalTiendaSeccionDto(
            @Valid final PtrPresenciaTotalTiendaSeccionRequestDto request);

    PtrPresenciaDetalleResponseDto getPresenciasDetalleDto(@Valid final PtrPresenciaDetalleRequestDto request);

    PtrPresenciaTiposHorasResponseDto getTiposHorasDto(@Valid final PtrPresenciaTiposHorasRequestDto request);

    PtrPresenciaDetalleComisionableResponseDto getPresenciasDetalleComisionableDto(
            @Valid PtrPresenciaDetalleComisionableRequestDto request);

    PtrPresenciaTotalTiendaResponseDto getPresenciasTotalTiendaDto(@Valid PtrPresenciaTotalTiendaRequestDto request);

    String test();

    String getVersion();

}
