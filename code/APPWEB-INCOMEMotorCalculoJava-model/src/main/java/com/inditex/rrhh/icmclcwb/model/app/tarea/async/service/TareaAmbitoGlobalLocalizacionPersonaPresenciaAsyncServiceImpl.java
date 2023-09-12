package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalLocalizacionPersonaPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncServiceImpl
    implements TareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncService {

  @Autowired
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaService tareaAmbitoGlobalLocalizacionPersonaPresenciaService;

  @Override
  public CompletableFuture<Void> savePtrPresenciaEmpleadosTiendaResponse(
      final PtrPresenciaEmpleadosTiendaResponseDto dto, final TareaDto tarea) {
    tareaAmbitoGlobalLocalizacionPersonaPresenciaService.save(dto, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
