package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaAmbitoService {

  List<TareaAmbitoDto> findByTarea(@Valid @NonNull final TareaDto tarea);

  List<TareaAmbitoDto> create(@Valid @NonNull @NotEmpty final List<TareaAmbitoDto> tareaAmbito,
      @Valid @NonNull final TareaDto tarea);

}
