package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionOnlineHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionOnlineHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaLocalizacionOnlineHistoricoAsyncServiceImpl implements TareaLocalizacionOnlineHistoricoAsyncService {

  @Autowired
  private TareaLocalizacionOnlineHistoricoService tareaLocalizacionOnlineHistoricoService;

  @Override
  public CompletableFuture<Void> save(List<TiendaOnlineResultItemDto> src, TareaDto tarea) {
    tareaLocalizacionOnlineHistoricoService.save(src, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
