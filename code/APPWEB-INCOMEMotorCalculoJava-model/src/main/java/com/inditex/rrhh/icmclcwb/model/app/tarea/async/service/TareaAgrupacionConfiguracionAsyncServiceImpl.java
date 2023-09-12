package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionConfiguracionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionConfiguracionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaAgrupacionConfiguracionAsyncServiceImpl implements TareaAgrupacionConfiguracionAsyncService {

  @Autowired
  private TareaAgrupacionConfiguracionService tareaAgrupacionConfiguracionService;

  @Override
  public CompletableFuture<Void> saveAgrupacionConfiguracionDto(List<ConfiguracionVentaOnlineResultItemDto> data,
      RunTareaDto tarea) {
    tareaAgrupacionConfiguracionService.saveConfiguracionVentaOnline(data, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
