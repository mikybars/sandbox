package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public interface TareaPersonaEstructuraService {

  List<TareaPersonaEstructuraDto> save(
      @Valid @NotNull @NotEmpty final List<TareaPersonaEstructuraDto> tareaPersonaEstructura,
      @Valid @NotNull final TareaDto tarea);

  List<TareaPersonaEstructuraDto> mergeEstructurasComResultItemDto(
      @Valid @NotNull @NotEmpty final List<EstructurasComResultItemDto> estructurasComResultItemDto,
      @Valid @NotNull final TareaDto tarea);

  List<IdPersonaLocalDto> findPersonasChallenge(@Valid @NotNull final TareaDto tarea);

  Boolean calcularFestivos(@Valid @NotNull final TareaDto tarea);

  List<TareaPersonaEstructuraDto> saveSimulacion(
      @Valid @NotNull @NotEmpty List<TareaPersonaEstructuraDto> tareaPersonaEstructura,
      @Valid @NotNull TareaDto tarea);
}
