package com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service;

/*
 * Copyright (c) 2021. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;

public interface RunTareaAmbitoValidarExternosSpainService {

  ValidacionDto execute(final RunTareaDto runTarea, final TareaAmbitoDto tareaAmbito,
      final TareaFaseAccionDto tareaFaseAccion);

}
