package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionFestivoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionFestivoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaLocalizacionFestivoAsyncServiceImpl implements TareaLocalizacionFestivoAsyncService {

  @Autowired
  private TareaLocalizacionFestivoService tareaLocalizacionFestivoService;

  @Override
  public CompletableFuture<Void> save(
      @NotNull final List<HorarioComercialFestivoDocDto> src,
      @NotNull final TareaDto tarea) {
    this.tareaLocalizacionFestivoService.save(src, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
