package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaAusenciaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaPersonaAusenciaHistoricoService {

  List<TareaPersonaAusenciaHistoricoDto> saveAusenciaResultItemDto(
      @Valid @NonNull @NotEmpty final List<AusenciasResultItemDto> src,
      @Valid @NonNull final TareaDto tarea);

  List<TareaPersonaAusenciaHistoricoDto> save(
      @Valid @NonNull @NotEmpty final List<TareaPersonaAusenciaHistoricoDto> tareaPersonaAusenciaHistorico);

}
