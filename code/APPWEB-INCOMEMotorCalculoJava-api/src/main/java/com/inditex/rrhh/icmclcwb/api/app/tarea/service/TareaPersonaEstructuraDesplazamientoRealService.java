package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.DesplazamientoRealDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDesplazamientoRealDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public interface TareaPersonaEstructuraDesplazamientoRealService {

  List<TareaPersonaEstructuraDesplazamientoRealDto> save(
      @Valid @NotNull @NotEmpty List<TareaPersonaEstructuraDesplazamientoRealDto> tareaPersonaEstructura,
      @Valid @NotNull TareaDto tarea);

  List<DesplazamientoRealDto> findDesplazamientoReal(@Valid @NotNull TareaDto tarea);

  List<TareaPersonaEstructuraDesplazamientoRealDto> saveDesplazamientoRealResultItemDto(
      @Valid @NotNull @NotEmpty List<DesplazamientoRealResultItemDto> desplazamientoReal,
      @Valid @NotNull TareaDto tarea);

}
