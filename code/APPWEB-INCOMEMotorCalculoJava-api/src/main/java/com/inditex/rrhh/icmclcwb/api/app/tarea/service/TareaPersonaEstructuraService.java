package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaPersonaEstructuraService {

  List<TareaPersonaEstructuraDto> save(
      @Valid @NonNull @NotEmpty final List<TareaPersonaEstructuraDto> tareaPersonaEstructura,
      @Valid @NonNull final TareaDto tarea);

  List<TareaPersonaEstructuraDto> mergeEstructurasComResultItemDto(
      @Valid @NonNull @NotEmpty final List<EstructurasComResultItemDto> estructurasComResultItemDto,
      @Valid @NonNull final TareaDto tarea);

  List<IdPersonaLocalDto> findPersonasChallenge(@Valid @NonNull final TareaDto tarea);

  Boolean calcularFestivos(@Valid @NonNull final TareaDto tarea);

}
