package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaAgrupacionVentaAsyncService {

  CompletableFuture<Void> savePtrVentaTotalizadoResponse(PtrVentaTotalizadoResponseDto dto, TareaDto tarea,
      List<TareaAgrupacionCadenasDto> agrupaciones);

  CompletableFuture<Void> savePtrVentaOnlineEntregaDomicilioResponse(PtrVentaOnlineEntregaDomicilioResponseDto dto,
      TareaDto tarea, List<TareaAgrupacionCadenasDto> agrupaciones);

}
