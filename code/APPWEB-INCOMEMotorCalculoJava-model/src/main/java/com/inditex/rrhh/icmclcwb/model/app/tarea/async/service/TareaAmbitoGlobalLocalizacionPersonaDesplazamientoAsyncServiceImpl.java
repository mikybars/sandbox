package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalLocalizacionPersonaDesplazamientoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncServiceImpl
    implements TareaAmbitoGlobalLocalizacionPersonaDesplazamientoAsyncService {

  @Autowired
  private TareaAmbitoGlobalLocalizacionPersonaDesplazamientoService tareaAmbitoGlobalLocalizacionPersonaDesplazamientoService;

  @Override
  public CompletableFuture<Void> saveGenericEmpleadoResultItemDto(final List<GenericEmpleadoResultItemDto> src,
      final TareaDto tareaDto) {
    tareaAmbitoGlobalLocalizacionPersonaDesplazamientoService.save(src, tareaDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
