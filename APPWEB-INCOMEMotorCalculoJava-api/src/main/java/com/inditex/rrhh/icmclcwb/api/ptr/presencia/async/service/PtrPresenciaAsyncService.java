package com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResponseDto;

public interface PtrPresenciaAsyncService {

    CompletableFuture<PtrPresenciaTotalTiendaSeccionResponseDto> getPresenciasTotalTiendaSeccionDto(
            final PtrPresenciaTotalTiendaSeccionRequestDto request) throws Exception;

    CompletableFuture<PtrPresenciaDetalleResponseDto> getPresenciasDetalleDto(
            final PtrPresenciaDetalleRequestDto request) throws Exception;

    CompletableFuture<PtrPresenciaTiposHorasResponseDto> getTiposHoras(final PtrPresenciaTiposHorasRequestDto request)
            throws Exception;

}
