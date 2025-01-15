package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarSlrhorcomsService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarSlrhorcomsService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaRecolectarSlrhorcomsServiceImpl implements RunTareaRecolectarSlrhorcomsService {

  @Autowired
  private RunTareaAmbitoRecolectarSlrhorcomsService runTareaAmbitoRecolectarSlrhorcomsService;

  @Override
  public void horarioComercialFestivoByRunTarea(
      @NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarSlrhorcomsService
            .horarioComercialFestivoByRunTareaAndTareaAmbito(runTarea, item));
  }

}
