package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalFechaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface TareaAmbitoGlobalFechaService {

  void save(@Valid @NonNull TareaAmbitoGlobalFechaDto src, @Valid @NonNull TareaDto tarea);

  PeriodoDto findFechaAmbitoDtoByIdTareaAndIdTipoDato(@Valid @NonNull Long idTarea, @NonNull Integer idTipoDato);

}
