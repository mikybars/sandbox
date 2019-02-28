package com.inditex.rrhh.icmclcwb.api.ptr.presencia.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResponseDto;

public interface PtrPresenciaService {

    PtrPresenciaTotalTiendaSeccionResponseDto presenciasTotalTiendaSeccion(
            @Valid final PtrPresenciaTotalTiendaSeccionRequestDto request);

    PtrPresenciaDetalleResponseDto presenciasDetalle(@Valid final PtrPresenciaDetalleRequestDto request);

    PtrPresenciaTiposHorasResponseDto tiposHoras(@Valid final PtrPresenciaTiposHorasRequestDto request);

    PtrPresenciaDetalleComisionableResponseDto presenciasDetalleComisionable(
            @Valid final PtrPresenciaDetalleComisionableRequestDto request);
    
    PtrPresenciaTiendasEmpleadoResponseDto presenciasTiendasEmpleado(
            @Valid final PtrPresenciaTiendasEmpleadoRequestDto request);

    PtrPresenciaTotalTiendaResponseDto presenciasTotalTienda(@Valid final PtrPresenciaTotalTiendaRequestDto request);

    String test();

    String version();



}
