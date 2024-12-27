package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionChallengeDiasMinimosDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaConfiguracionChallengeDiasMinimosService {

  void save(@Valid @NonNull @NotEmpty final List<TareaConfiguracionChallengeDiasMinimosDto> src,
      @Valid @NonNull final TareaDto tarea);

  void saveConfChDiasMinimosResultItemDto(@Valid @NonNull @NotEmpty final List<ConfChDiasMinimosResultItemDto> src,
      @Valid @NonNull final TareaDto tarea);

}
