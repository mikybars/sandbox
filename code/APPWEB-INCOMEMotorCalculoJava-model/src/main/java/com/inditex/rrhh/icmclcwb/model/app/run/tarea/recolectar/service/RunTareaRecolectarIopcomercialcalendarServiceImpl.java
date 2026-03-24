package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarIopcomercialcalendarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarIopcomercialcalendarService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaRecolectarIopcomercialcalendarServiceImpl implements RunTareaRecolectarIopcomercialcalendarService {

  private final RunTareaAmbitoRecolectarIopcomercialcalendarService runTareaAmbitoRecolectarIopcomercialcalendarService;

  @Override
  public void horarioComercialFestivoByRunTarea(
      @NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarIopcomercialcalendarService
            .horarioComercialFestivoByRunTareaAndTareaAmbito(runTarea, item));
  }

}
