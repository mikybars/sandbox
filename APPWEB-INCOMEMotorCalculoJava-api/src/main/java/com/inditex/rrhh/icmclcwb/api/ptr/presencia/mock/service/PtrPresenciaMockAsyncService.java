package com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTotalTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTiposHorasResponseDto;

public interface PtrPresenciaMockAsyncService {

    CompletableFuture<List<PtrPresenciasMockDetalleResponseDto>> presenciasDetalle(final PtrPresenciasMockDetalleRequestDto request);

    CompletableFuture<List<PtrPresenciasMockDetalleComisionableResponseDto>> presenciasDetalleComisionable(
            final PtrPresenciasMockDetalleComisionableRequestDto request);

    CompletableFuture<List<PtrPresenciasMockTotalTiendaResponseDto>> presenciasTotalTienda(
            final PtrPresenciasMockTotalTiendaRequestDto request);

    CompletableFuture<List<PtrPresenciasMockTotalTiendaSeccionResponseDto>> presenciasTotalTiendaSeccion(
            final PtrPresenciasMockTotalTiendaSeccionRequestDto request);

    CompletableFuture<List<PtrPresenciasMockTiposHorasResponseDto>> tiposHoras(final PtrPresenciasMockTiposHorasRequestDto request);

}