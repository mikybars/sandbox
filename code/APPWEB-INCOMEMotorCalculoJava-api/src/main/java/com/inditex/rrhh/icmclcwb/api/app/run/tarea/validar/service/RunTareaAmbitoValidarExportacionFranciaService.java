package com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;

import jakarta.validation.Valid;

public interface RunTareaAmbitoValidarExportacionFranciaService {

  ValidacionDto execute(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito,
      @Valid TareaFaseAccionDto tareaFaseAccion);
}
