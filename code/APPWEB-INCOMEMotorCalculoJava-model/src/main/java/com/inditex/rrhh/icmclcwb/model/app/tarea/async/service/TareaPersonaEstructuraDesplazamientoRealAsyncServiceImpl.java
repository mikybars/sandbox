package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaEstructuraDesplazamientoRealAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDesplazamientoRealDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraDesplazamientoRealService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealResultItemDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaPersonaEstructuraDesplazamientoRealAsyncServiceImpl
    implements TareaPersonaEstructuraDesplazamientoRealAsyncService {

  @Autowired
  private TareaPersonaEstructuraDesplazamientoRealService tareaPersonaEstructuraDesplazamientoRealService;

  @Override
  public CompletableFuture<Void> save(final List<TareaPersonaEstructuraDesplazamientoRealDto> src,
      final TareaDto tarea) {
    this.tareaPersonaEstructuraDesplazamientoRealService.save(src, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> saveDesplazamientoRealResultItemDto(final List<DesplazamientoRealResultItemDto> src,
      final TareaDto tarea) {
    this.tareaPersonaEstructuraDesplazamientoRealService.saveDesplazamientoRealResultItemDto(src, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
