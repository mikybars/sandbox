package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaEstructuraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaPersonaEstructuraAsyncServiceImpl implements TareaPersonaEstructuraAsyncService {

  @Autowired
  private TareaPersonaEstructuraService tareaPersonaEstructuraService;

  @Override
  public CompletableFuture<Void> save(List<TareaPersonaEstructuraDto> tareaPersonaEstructura,
      TareaDto tareaDto) {
    this.tareaPersonaEstructuraService.save(tareaPersonaEstructura, tareaDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> saveEstructurasComResultItemDto(
      List<EstructurasComResultItemDto> estructurasComResultItemDto, TareaDto tareaDto) {
    this.tareaPersonaEstructuraService.save(
        this.tareaPersonaEstructuraService.mergeEstructurasComResultItemDto(estructurasComResultItemDto, tareaDto),
        tareaDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
