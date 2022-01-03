package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaPersonaHistoricoAsyncServiceImpl implements TareaPersonaHistoricoAsyncService {

  @Autowired
  private TareaPersonaHistoricoService tareaPersonaHistoricoService;

  @Override
  public CompletableFuture<Void> save(final List<TareaPersonaHistoricoDto> tareaPersonaHistorico,
      final TareaDto tarea) {
    tareaPersonaHistoricoService.save(tareaPersonaHistorico);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> saveGenericEmpleadoResultItemDto(
      final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto, final TareaDto tarea) {
    tareaPersonaHistoricoService.save(tareaPersonaHistoricoService.merge(genericEmpleadoResultItemDto, tarea));
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
