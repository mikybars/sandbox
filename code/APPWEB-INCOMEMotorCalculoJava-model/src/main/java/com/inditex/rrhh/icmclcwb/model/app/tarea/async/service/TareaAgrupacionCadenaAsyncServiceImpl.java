package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionCadenaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionCadenaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.rest.client.dto.AgrupacionesOnlineResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaAgrupacionCadenaAsyncServiceImpl implements TareaAgrupacionCadenaAsyncService {

  @Autowired
  private TareaAgrupacionCadenaService tareaAgrupacionCadenaService;

  @Override
  public CompletableFuture<Void> save(List<AgrupacionesOnlineResponseDTO> src, TareaDto tarea) {
    this.tareaAgrupacionCadenaService.save(src, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
