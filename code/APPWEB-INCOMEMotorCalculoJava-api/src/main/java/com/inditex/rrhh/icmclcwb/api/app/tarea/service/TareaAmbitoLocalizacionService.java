package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public interface TareaAmbitoLocalizacionService {

  List<TareaAmbitoLocalizacionDto> findByTarea(@Valid @NotNull final TareaDto tarea);

  List<TareaAmbitoLocalizacionDto> create(
      @Valid @NotNull @NotEmpty final List<TareaAmbitoLocalizacionDto> tareaAmbitoLocalizacion,
      @Valid @NotNull final TareaDto tarea);

}
