package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaLocalizacionComisionHistoricoService {

  List<TareaLocalizacionComisionHistoricoDto> merge(
      @Valid @NonNull @NotEmpty final List<GenericTiendaResultItemDto> genericTiendaResultItemDto,
      @Valid @NonNull final TareaDto tarea);

  List<TareaLocalizacionComisionHistoricoDto> save(
      @Valid @NonNull @NotEmpty final List<TareaLocalizacionComisionHistoricoDto> tareaLocalizacionComisionHistorico);

}
