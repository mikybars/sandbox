package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaAusenciaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public interface TareaPersonaAusenciaHistoricoService {

  List<TareaPersonaAusenciaHistoricoDto> saveAusenciaResultItemDto(
      @Valid @NotNull @NotEmpty final List<AusenciasResultItemDto> src,
      @Valid @NotNull final TareaDto tarea);

  List<TareaPersonaAusenciaHistoricoDto> save(
      @Valid @NotNull @NotEmpty final List<TareaPersonaAusenciaHistoricoDto> tareaPersonaAusenciaHistorico);

}
