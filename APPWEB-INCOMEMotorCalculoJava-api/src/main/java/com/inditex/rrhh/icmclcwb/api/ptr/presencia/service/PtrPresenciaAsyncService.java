package com.inditex.rrhh.icmclcwb.api.ptr.presencia.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;

public interface PtrPresenciaAsyncService {

    CompletableFuture<PtrPresenciaTotalTiendaSeccionResponseDto> getPresenciasTotalTiendaSeccionDto(
            PtrPresenciaTotalTiendaSeccionRequestDto request) throws Exception;

    CompletableFuture<PtrPresenciaDetalleResponseDto> getPresenciasDetalleDto(PtrPresenciaDetalleRequestDto request)
            throws Exception;
    
    CompletableFuture<PtrPresenciaTiposHorasResponseDto> getTiposHoras(final PtrPresenciaTiposHorasRequestDto request) throws Exception;


}
