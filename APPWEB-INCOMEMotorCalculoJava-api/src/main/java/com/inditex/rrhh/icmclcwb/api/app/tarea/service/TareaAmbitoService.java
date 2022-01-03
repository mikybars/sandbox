package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface TareaAmbitoService {

  List<TareaAmbitoDto> findByTarea(@Valid @NotNull final TareaDto tarea);

  List<TareaAmbitoDto> create(@Valid @NotNull @NotEmpty final List<TareaAmbitoDto> tareaAmbito,
      @Valid @NotNull final TareaDto tarea);

}
