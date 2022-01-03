package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLimpiezaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLimpiezaService;
import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaLimpiezaAsynServiceImpl implements TareaLimpiezaAsyncService {

  @Autowired
  private TareaLimpiezaService tareaLimpiezaService;

  @Override
  public CompletableFuture<TareaLimpiezaDto> save(
      final TareaLimpiezaDto tareaLimpieza) {
    final TareaLimpiezaDto limpieza = this.tareaLimpiezaService.save(tareaLimpieza);
    return CompletableFuture.completedFuture(limpieza);
  }

  @Override
  public CompletableFuture<List<TareaLimpiezaDto>> save(
      final List<IdTareaDTO> idTareas) {
    final List<TareaLimpiezaDto> limpiezas = this.tareaLimpiezaService.save(idTareas);
    return CompletableFuture.completedFuture(limpiezas);
  }

}
