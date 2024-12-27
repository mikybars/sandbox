package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResultItemDto;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaLocalizacionPresenciaAsyncServiceImpl
    implements TareaLocalizacionPresenciaAsyncService {

  @Autowired
  private TareaLocalizacionPresenciaService tareaLocalizacionPresenciaService;

  @Override
  public CompletableFuture<Void> save(@NonNull final List<PresenciaManualWlocResultItemDto> src,
      @NonNull final TareaDto tareaDto) {
    this.tareaLocalizacionPresenciaService.save(src, tareaDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
