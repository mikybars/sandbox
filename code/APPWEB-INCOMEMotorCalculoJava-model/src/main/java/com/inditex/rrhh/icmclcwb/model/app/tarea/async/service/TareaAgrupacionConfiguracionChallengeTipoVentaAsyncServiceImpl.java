package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionConfiguracionChallengeTipoVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionConfiguracionChallengeTipoVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionConfiguracionChallengeTipoVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaAgrupacionConfiguracionChallengeTipoVentaAsyncServiceImpl
    implements TareaAgrupacionConfiguracionChallengeTipoVentaAsyncService {

  @Autowired
  private TareaAgrupacionConfiguracionChallengeTipoVentaService tareaAgrupacionConfiguracionChallengeTipoVentaService;

  @Override
  public CompletableFuture<Void> save(List<TareaAgrupacionConfiguracionChallengeTipoVentaDto> src, TareaDto tarea) {
    tareaAgrupacionConfiguracionChallengeTipoVentaService.save(src, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> saveConfChTpVentaResultItemDto(List<ConfChTpVentaResultItemDto> src,
      TareaDto tarea) {
    tareaAgrupacionConfiguracionChallengeTipoVentaService.saveConfChTpVentaResultItemDto(src, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
