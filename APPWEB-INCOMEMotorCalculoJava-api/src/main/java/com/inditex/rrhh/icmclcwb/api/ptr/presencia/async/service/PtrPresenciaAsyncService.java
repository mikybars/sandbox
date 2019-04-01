package com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

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

@Async("ptrPresenciaExecutor")
public interface PtrPresenciaAsyncService {

    CompletableFuture<PtrPresenciaTotalTiendaResponseDto> presenciasTotalTienda(
            PtrPresenciaTotalTiendaRequestDto request);
    
    CompletableFuture<PtrPresenciaTotalTiendaSeccionResponseDto> presenciasTotalTiendaSeccion(
            final PtrPresenciaTotalTiendaSeccionRequestDto request);

    CompletableFuture<PtrPresenciaDetalleResponseDto> presenciasDetalle(
            final PtrPresenciaDetalleRequestDto request);

    CompletableFuture<PtrPresenciaTiposHorasResponseDto> tiposHoras(final PtrPresenciaTiposHorasRequestDto request);

    CompletableFuture<PtrPresenciaDetalleComisionableResponseDto> presenciasDetalleComisionable(
            final PtrPresenciaDetalleComisionableRequestDto request);
    
    CompletableFuture<PtrPresenciaTiendasEmpleadoResponseDto> presenciasTiendasEmpleado(
            final PtrPresenciaTiendasEmpleadoRequestDto request);
    
    CompletableFuture<PtrPresenciaTiendasEmpleadoResponseDto> presenciaDetalleComisionablePersonaByRunTarea(
            PtrPresenciaTiendasEmpleadoRequestDto request);

    CompletableFuture<String> version();

    CompletableFuture<String> test();

}
