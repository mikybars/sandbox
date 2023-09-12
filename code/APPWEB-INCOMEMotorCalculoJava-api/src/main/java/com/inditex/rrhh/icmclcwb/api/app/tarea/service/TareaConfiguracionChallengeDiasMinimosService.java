package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionChallengeDiasMinimosDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResultItemDto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface TareaConfiguracionChallengeDiasMinimosService {

  void save(@Valid @NotNull @NotEmpty final List<TareaConfiguracionChallengeDiasMinimosDto> src,
      @Valid @NotNull final TareaDto tarea);

  void saveConfChDiasMinimosResultItemDto(@Valid @NotNull @NotEmpty final List<ConfChDiasMinimosResultItemDto> src,
      @Valid @NotNull final TareaDto tarea);

}
