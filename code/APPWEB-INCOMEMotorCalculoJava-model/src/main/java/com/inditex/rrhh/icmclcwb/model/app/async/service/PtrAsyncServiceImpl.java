package com.inditex.rrhh.icmclcwb.model.app.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.async.service.PtrAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.PtrService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PtrAsyncServiceImpl implements PtrAsyncService {

  @Autowired
  private PtrService ptrService;

  @Override
  public CompletableFuture<PresenciaOrigenDto> findPresenciasOrigenAndFecha(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    return CompletableFuture
        .completedFuture(this.ptrService.findPresenciasOrigenAndFecha(runTareaDto, tareaAmbito));
  }

  @Override
  public CompletableFuture<PresenciaOrigenDto> findPresenciasOrigenAndFechaEs(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    return CompletableFuture
        .completedFuture(this.ptrService.findPresenciasOrigenAndFechaEs(runTareaDto, tareaAmbito));
  }

}
