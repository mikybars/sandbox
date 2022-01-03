package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaCoeficienteAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaCoeficienteService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaPersonaCoeficienteAsyncServiceImpl implements TareaPersonaCoeficienteAsyncService {

  @Autowired
  private TareaPersonaCoeficienteService tareaPersonaCoeficienteService;

  @Override
  public CompletableFuture<Void> save(final List<GenericEmpleadoResultItemDto> src,
      final TareaDto tarea) {
    tareaPersonaCoeficienteService.save(src, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
