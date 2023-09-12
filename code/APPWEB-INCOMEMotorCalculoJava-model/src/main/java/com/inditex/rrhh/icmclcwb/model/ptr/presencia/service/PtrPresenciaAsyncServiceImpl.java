package com.inditex.rrhh.icmclcwb.model.ptr.presencia.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PtrPresenciaAsyncServiceImpl implements PtrPresenciaAsyncService {

  @Autowired
  private PtrPresenciaService ptrPresenciaService;

  @Override
  public CompletableFuture<PtrPresenciaTotalizadoResponseDto> presenciasTotalizado(
      final PtrPresenciaTotalizadoRequestDto request) {
    return CompletableFuture.completedFuture(this.ptrPresenciaService.presenciasTotalizado(request));
  }

  @Override
  public CompletableFuture<PtrPresenciaDetalleResponseDto> presenciasDetalle(
      final PtrPresenciaDetalleRequestDto request) {
    return CompletableFuture.completedFuture(this.ptrPresenciaService.presenciasDetalle(request));
  }

  @Override
  public CompletableFuture<PtrPresenciaTiendasEmpleadoResponseDto> presenciaDetalleComisionablePersonaByRunTarea(
      final PtrPresenciaTiendasEmpleadoRequestDto request) {
    return CompletableFuture.completedFuture(this.ptrPresenciaService.presenciasTiendasEmpleado(request));
  }

  @Override
  public CompletableFuture<PtrPresenciaTiendasEmpleadoResponseDto> presenciasTiendasEmpleado(
      final PtrPresenciaTiendasEmpleadoRequestDto request) {
    return CompletableFuture.completedFuture(this.ptrPresenciaService.presenciasTiendasEmpleado(request));
  }

  @Override
  public CompletableFuture<PtrPresenciaEmpleadosTiendaResponseDto> presenciasEmpleadosTienda(
      final PtrPresenciaEmpleadosTiendaRequestDto request) {
    return CompletableFuture.completedFuture(this.ptrPresenciaService.presenciasEmpleadosTienda(request));
  }

  @Override
  public CompletableFuture<PtrPresenciaTiposHorasResponseDto> tiposHoras(
      final PtrPresenciaTiposHorasRequestDto request) {
    return CompletableFuture.completedFuture(this.ptrPresenciaService.tiposHoras(request));
  }
}
