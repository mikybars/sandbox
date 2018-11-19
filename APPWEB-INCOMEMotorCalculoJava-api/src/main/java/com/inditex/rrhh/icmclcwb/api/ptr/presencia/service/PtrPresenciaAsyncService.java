package com.inditex.rrhh.icmclcwb.api.ptr.presencia.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaSeccionResponseDto;

public interface PtrPresenciaAsyncService {

    CompletableFuture<PresenciasTotalTiendaSeccionResponseDto> getPresenciasTotalTiendaSeccionDto(
            PresenciasTotalTiendaSeccionRequestDto request) throws Exception;

    CompletableFuture<PresenciasDetalleResponseDto> getPresenciasDetalleDto(PresenciasDetalleRequestDto request)
            throws Exception;

}
