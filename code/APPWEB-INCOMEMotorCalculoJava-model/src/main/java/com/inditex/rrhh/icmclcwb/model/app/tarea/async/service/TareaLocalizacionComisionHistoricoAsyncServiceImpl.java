package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionComisionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionComisionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaLocalizacionComisionHistoricoAsyncServiceImpl
    implements TareaLocalizacionComisionHistoricoAsyncService {

  @Autowired
  private TareaLocalizacionComisionHistoricoService tareaTiendaComisionHistoricoService;

  @Override
  public CompletableFuture<Void> save(
      final List<TareaLocalizacionComisionHistoricoDto> tareaTiendaComisionHistoricoDto, TareaDto tarea) {
    tareaTiendaComisionHistoricoService.save(tareaTiendaComisionHistoricoDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> saveGenericTiendaResultItemDto(
      final List<GenericTiendaResultItemDto> genericTiendaResultItemDto, TareaDto tarea) {
    tareaTiendaComisionHistoricoService
        .save(tareaTiendaComisionHistoricoService.merge(genericTiendaResultItemDto, tarea));
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
