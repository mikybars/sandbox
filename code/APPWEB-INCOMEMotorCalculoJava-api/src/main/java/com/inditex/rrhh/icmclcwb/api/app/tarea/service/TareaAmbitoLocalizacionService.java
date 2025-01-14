package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaAmbitoLocalizacionService {

  List<TareaAmbitoLocalizacionDto> findByTarea(@Valid @NonNull final TareaDto tarea);

  List<TareaAmbitoLocalizacionDto> create(
      @Valid @NonNull @NotEmpty final List<TareaAmbitoLocalizacionDto> tareaAmbitoLocalizacion,
      @Valid @NonNull final TareaDto tarea);

}
