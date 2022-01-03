package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaLocalizacionHistoricoAsyncServiceImpl implements TareaLocalizacionHistoricoAsyncService {

  @Autowired
  private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

  @Override
  public CompletableFuture<Void> save(final List<TareaLocalizacionHistoricoDto> tareaLocalizacionHistorico,
      final TareaDto tarea) {
    tareaLocalizacionHistoricoService.save(tareaLocalizacionHistorico);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> saveGenericTiendaResultItemDto(
      final List<GenericTiendaResultItemDto> genericTiendaResultItemDto, final TareaDto tarea) {
    tareaLocalizacionHistoricoService
        .save(tareaLocalizacionHistoricoService.merge(genericTiendaResultItemDto, tarea));
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
