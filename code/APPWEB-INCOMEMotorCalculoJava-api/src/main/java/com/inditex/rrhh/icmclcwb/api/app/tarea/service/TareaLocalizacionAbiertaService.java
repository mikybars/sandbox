package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface TareaLocalizacionAbiertaService {

  void saveAbierto(@Valid @NotNull final TareaDto tareaDto, @Valid @NotNull final TrabajoDTO trabajoDto);

  void saveCerrado(@Valid @NotNull final TareaDto tareaDto, @Valid @NotNull final TrabajoDTO trabajoDto);

}
