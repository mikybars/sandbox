package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public interface TareaLocalizacionComisionHistoricoService {

  List<TareaLocalizacionComisionHistoricoDto> merge(
      @Valid @NotNull @NotEmpty final List<GenericTiendaResultItemDto> genericTiendaResultItemDto,
      @Valid @NotNull final TareaDto tarea);

  List<TareaLocalizacionComisionHistoricoDto> save(
      @Valid @NotNull @NotEmpty final List<TareaLocalizacionComisionHistoricoDto> tareaLocalizacionComisionHistorico);

}
