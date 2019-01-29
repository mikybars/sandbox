package com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;

public interface PtrPresenciaMockAsyncService {

    CompletableFuture<List<PtrPresenciaDetalleResultItemDto>> presenciasDetalle(final PtrPresenciaDetalleRequestDto request);

    CompletableFuture<List<PtrPresenciaDetalleComisionableResultItemDto>> presenciasDetalleComisionable(
            final PtrPresenciaDetalleComisionableRequestDto request);

    CompletableFuture<List<PtrPresenciaTotalTiendaResultItemDto>> presenciasTotalTienda(
            final PtrPresenciaTotalTiendaRequestDto request);

    CompletableFuture<List<PtrPresenciaTotalTiendaSeccionResultItemDto>> presenciasTotalTiendaSeccion(
            final PtrPresenciaTotalTiendaSeccionRequestDto request);

    CompletableFuture<List<PtrPresenciaTiposHorasResultItemDto>> tiposHoras(final PtrPresenciaTiposHorasRequestDto request);

}