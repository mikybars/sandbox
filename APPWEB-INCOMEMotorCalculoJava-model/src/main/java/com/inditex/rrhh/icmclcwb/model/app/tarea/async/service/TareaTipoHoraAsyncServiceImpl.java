package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTipoHoraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTipoHoraService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaTipoHoraAsyncServiceImpl implements TareaTipoHoraAsyncService {

  @Autowired
  private TareaTipoHoraService tareaTipoHoraService;

  @Override
  public CompletableFuture<Void> save(
      final TiposHoraResponseDto dto,
      final TareaDto tarea) {
    this.tareaTipoHoraService.save(dto, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
