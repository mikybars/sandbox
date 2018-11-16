package com.inditex.rrhh.icmclcwb.api.ptr.presencia.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaSeccionResponseDto;

public interface PtrPresenciaService {

	CompletableFuture<PresenciasTotalTiendaSeccionResponseDto> getPresenciasTotalTiendaSeccionDto(
			@Valid PresenciasTotalTiendaSeccionRequestDto getVentaTotalizadoRequest) throws Exception;

	CompletableFuture<PresenciasDetalleResponseDto> getPresenciasDetalleDto(
			@Valid PresenciasDetalleRequestDto getPresenciasDetalleRequestDto) throws Exception;

}
