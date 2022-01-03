package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaConfiguracionPrecioHoraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionPrecioHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaConfiguracionPrecioHoraService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResultItemDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaConfiguracionPrecioHoraAsyncServiceImpl
    implements TareaConfiguracionPrecioHoraAsyncService {

  @Autowired
  private TareaConfiguracionPrecioHoraService tareaConfiguracionPrecioHoraService;

  @Override
  public CompletableFuture<Void> save(List<TareaConfiguracionPrecioHoraDto> src, TareaDto tarea) {
    tareaConfiguracionPrecioHoraService.save(src, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> saveConfPrecioHoraResultItemDto(List<ConfPrecioHoraResultItemDto> src,
      TareaDto tarea) {
    tareaConfiguracionPrecioHoraService.saveConfPrecioHoraResultItemDto(src, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
