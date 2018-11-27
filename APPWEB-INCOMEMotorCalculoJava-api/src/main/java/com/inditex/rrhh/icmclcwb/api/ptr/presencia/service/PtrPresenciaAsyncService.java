package com.inditex.rrhh.icmclcwb.api.ptr.presencia.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciasDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciasTotalTiendaSeccionResponseDto;

public interface PtrPresenciaAsyncService {

    CompletableFuture<PtrPresenciasTotalTiendaSeccionResponseDto> getPresenciasTotalTiendaSeccionDto(
            PtrPresenciasTotalTiendaSeccionRequestDto request) throws Exception;

    CompletableFuture<PtrPresenciasDetalleResponseDto> getPresenciasDetalleDto(PtrPresenciasDetalleRequestDto request)
            throws Exception;

}
