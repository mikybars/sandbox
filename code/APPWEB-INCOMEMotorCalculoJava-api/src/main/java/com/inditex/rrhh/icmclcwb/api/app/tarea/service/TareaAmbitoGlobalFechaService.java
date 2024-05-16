package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalFechaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface TareaAmbitoGlobalFechaService {

  void save(@Valid @NotNull TareaAmbitoGlobalFechaDto src, @Valid @NotNull TareaDto tarea);

  PeriodoDto findFechaAmbitoDtoByIdTareaAndIdTipoDato(@Valid @NotNull Long idTarea, @NotNull Integer idTipoDato);

}
