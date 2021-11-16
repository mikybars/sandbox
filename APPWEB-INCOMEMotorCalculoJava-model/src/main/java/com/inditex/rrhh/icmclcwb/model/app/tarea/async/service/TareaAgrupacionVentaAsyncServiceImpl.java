package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaAgrupacionVentaAsyncServiceImpl implements TareaAgrupacionVentaAsyncService {

  @Autowired
  private TareaAgrupacionVentaService tareaAgrupacionVentaService;

  @Override
  public CompletableFuture<Void> savePtrVentaTotalizadoResponse(PtrVentaTotalizadoResponseDto dto, TareaDto tarea,
      List<TareaAgrupacionCadenasDto> agrupaciones) {
    tareaAgrupacionVentaService.savePtrVentaTotalizadoResponse(dto, tarea, agrupaciones);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> savePtrVentaOnlineEntregaDomicilioResponse(
      PtrVentaOnlineEntregaDomicilioResponseDto dto, TareaDto tarea,
      List<TareaAgrupacionCadenasDto> agrupaciones) {
    tareaAgrupacionVentaService.savePtrVentaOnlineEntregaDomicilioResponse(dto, tarea, agrupaciones);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
