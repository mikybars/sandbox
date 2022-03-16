package com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResponseDto;

import org.springframework.scheduling.annotation.Async;

@Async("ptrPresenciaExecutor")
public interface PtrPresenciaAsyncService {

  CompletableFuture<PtrPresenciaTotalizadoResponseDto> presenciasTotalizado(
      final PtrPresenciaTotalizadoRequestDto request);

  CompletableFuture<PtrPresenciaDetalleResponseDto> presenciasDetalle(
      final PtrPresenciaDetalleRequestDto request);

  CompletableFuture<PtrPresenciaTiendasEmpleadoResponseDto> presenciasTiendasEmpleado(
      final PtrPresenciaTiendasEmpleadoRequestDto request);

  CompletableFuture<PtrPresenciaTiendasEmpleadoResponseDto> presenciaDetalleComisionablePersonaByRunTarea(
      final PtrPresenciaTiendasEmpleadoRequestDto request);

  CompletableFuture<PtrPresenciaEmpleadosTiendaResponseDto> presenciasEmpleadosTienda(
      final PtrPresenciaEmpleadosTiendaRequestDto request);

  CompletableFuture<PtrPresenciaTiposHorasResponseDto> tiposHoras(
      final PtrPresenciaTiposHorasRequestDto request);
}
