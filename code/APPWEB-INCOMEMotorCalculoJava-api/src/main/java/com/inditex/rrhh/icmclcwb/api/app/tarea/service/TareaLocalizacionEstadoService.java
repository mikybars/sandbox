package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionEstadoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaLocalizacionEstadoService {

  List<TareaLocalizacionEstadoDto> save(
      @Valid @NonNull @NotEmpty List<TareaLocalizacionEstadoDto> tareaLocalizacionEstadoDto);

  List<TareaLocalizacionEstadoDto> merge(
      @Valid @NonNull @NotEmpty List<EstadoWlocResultItemDto> estadoWlocResultItemDto,
      @Valid @NonNull TareaDto tarea);
}
