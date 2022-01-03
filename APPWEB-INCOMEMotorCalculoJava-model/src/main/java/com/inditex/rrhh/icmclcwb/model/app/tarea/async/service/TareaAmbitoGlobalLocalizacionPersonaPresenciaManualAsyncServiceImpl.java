package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaPresenciaManualAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalLocalizacionPersonaPresenciaManualService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaAmbitoGlobalLocalizacionPersonaPresenciaManualAsyncServiceImpl
    implements TareaAmbitoGlobalLocalizacionPersonaPresenciaManualAsyncService {

  @Autowired
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaManualService tareaAmbitoGlobalLocalizacionPersonaPresenciaManualService;

  @Override
  public CompletableFuture<Void> saveGenericEmpleadoResultItemDto(final List<GenericEmpleadoResultItemDto> src,
      final TareaDto tareaDto) {
    tareaAmbitoGlobalLocalizacionPersonaPresenciaManualService.save(src, tareaDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
