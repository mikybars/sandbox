package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaAusenciaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaAusenciaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaPersonaAusenciaHistoricoAsyncServiceImpl implements TareaPersonaAusenciaHistoricoAsyncService {

  @Autowired
  private TareaPersonaAusenciaHistoricoService tareaPersonaAusenciaHistoricoService;

  @Override
  public CompletableFuture<Void> saveAusenciaResultItemDto(final List<AusenciasResultItemDto> src,
      final TareaDto tarea) {
    tareaPersonaAusenciaHistoricoService.saveAusenciaResultItemDto(src, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
