package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface RunTareaRecolectarSlrhorcomsService {

  void horarioComercialFestivoByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

}
