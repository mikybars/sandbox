package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarSlrhorcomsService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarSlrhorcomsService;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaRecolectarSlrhorcomsServiceImpl implements RunTareaRecolectarSlrhorcomsService {

  private final RunTareaAmbitoRecolectarSlrhorcomsService runTareaAmbitoRecolectarSlrhorcomsService;

  @Override
  public void horarioComercialFestivoByRunTarea(
      @NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarSlrhorcomsService
            .horarioComercialFestivoByRunTareaAndTareaAmbito(runTarea, item));
  }

}
