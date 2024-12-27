package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface TareaLocalizacionAbiertaService {

  void saveAbierto(@Valid @NonNull final TareaDto tareaDto, @Valid @NonNull final TrabajoDTO trabajoDto);

  void saveCerrado(@Valid @NonNull final TareaDto tareaDto, @Valid @NonNull final TrabajoDTO trabajoDto);

}
