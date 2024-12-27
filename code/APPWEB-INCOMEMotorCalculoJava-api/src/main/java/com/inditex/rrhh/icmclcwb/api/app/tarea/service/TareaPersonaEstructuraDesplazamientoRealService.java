package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.DesplazamientoRealDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDesplazamientoRealDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaPersonaEstructuraDesplazamientoRealService {

  List<TareaPersonaEstructuraDesplazamientoRealDto> save(
      @Valid @NonNull @NotEmpty List<TareaPersonaEstructuraDesplazamientoRealDto> tareaPersonaEstructura,
      @Valid @NonNull TareaDto tarea);

  List<DesplazamientoRealDto> findDesplazamientoReal(@Valid @NonNull TareaDto tarea);

  List<TareaPersonaEstructuraDesplazamientoRealDto> saveDesplazamientoRealResultItemDto(
      @Valid @NonNull @NotEmpty List<DesplazamientoRealResultItemDto> desplazamientoReal,
      @Valid @NonNull TareaDto tarea);

}
