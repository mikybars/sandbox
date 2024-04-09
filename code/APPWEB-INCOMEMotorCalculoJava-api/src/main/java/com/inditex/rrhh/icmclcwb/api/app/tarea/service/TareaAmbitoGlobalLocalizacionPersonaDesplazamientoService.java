package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public interface TareaAmbitoGlobalLocalizacionPersonaDesplazamientoService {

  void save(@Valid @NotNull @NotEmpty final List<GenericEmpleadoResultItemDto> src,
      @Valid @NotNull final TareaDto tareaDto);

}
