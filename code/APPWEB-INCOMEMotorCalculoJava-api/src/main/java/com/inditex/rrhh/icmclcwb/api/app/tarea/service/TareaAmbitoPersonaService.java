package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaAmbitoPersonaService {

  List<TareaAmbitoPersonaDto> findByTarea(@Valid @NonNull final TareaDto tarea);

  List<TareaAmbitoPersonaDto> create(@Valid @NonNull @NotEmpty final List<TareaAmbitoPersonaDto> tareaAmbitoPersona,
      @Valid @NonNull final TareaDto tarea);

}
