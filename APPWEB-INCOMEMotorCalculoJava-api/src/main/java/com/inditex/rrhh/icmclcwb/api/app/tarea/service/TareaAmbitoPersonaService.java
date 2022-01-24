package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface TareaAmbitoPersonaService {

  List<TareaAmbitoPersonaDto> findByTarea(@Valid @NotNull final TareaDto tarea);

  List<TareaAmbitoPersonaDto> create(@Valid @NotNull @NotEmpty final List<TareaAmbitoPersonaDto> tareaAmbitoPersona,
      @Valid @NotNull final TareaDto tarea);

}
