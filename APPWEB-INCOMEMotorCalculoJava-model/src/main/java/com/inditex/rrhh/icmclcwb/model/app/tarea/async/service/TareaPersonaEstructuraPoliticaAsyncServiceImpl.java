package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaEstructuraPoliticaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraPoliticaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaPersonaEstructuraPoliticaAsyncServiceImpl implements TareaPersonaEstructuraPoliticaAsyncService {

  @Autowired
  private TareaPersonaEstructuraPoliticaService tareaPersonaEstructuraPoliticaService;

  @Override
  public CompletableFuture<Void> save(List<ComisionEmpleadoResultItemDto> src, TareaDto tarea) {
    tareaPersonaEstructuraPoliticaService.save(src, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> saveEstructurasPolResultItemDto(List<EstructurasPolResultItemDto> src,
      TareaDto tarea) {
    tareaPersonaEstructuraPoliticaService.saveEstructurasPolResultItemDto(src, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
