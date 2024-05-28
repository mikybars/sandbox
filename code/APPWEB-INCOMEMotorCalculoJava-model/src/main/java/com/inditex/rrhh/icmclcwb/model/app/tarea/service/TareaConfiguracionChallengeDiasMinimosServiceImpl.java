package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionChallengeDiasMinimosDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaConfiguracionChallengeDiasMinimosService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaConfiguracionChallengeDiasMinimosMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaConfiguracionChallengeDiasMinimosRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class TareaConfiguracionChallengeDiasMinimosServiceImpl
    implements TareaConfiguracionChallengeDiasMinimosService {

  @Autowired
  private TareaConfiguracionChallengeDiasMinimosMapper tareaConfiguracionChallengeDiasMinimosMapper;

  @Autowired
  private TareaConfiguracionChallengeDiasMinimosRepositoryCustom tareaConfiguracionChallengeDiasMinimosRepositoryCustom;

  @Override
  public void save(@Valid @NotNull @NotEmpty final List<TareaConfiguracionChallengeDiasMinimosDto> src,
      @Valid @NotNull final TareaDto tarea) {
    tareaConfiguracionChallengeDiasMinimosRepositoryCustom.save(
        tareaConfiguracionChallengeDiasMinimosMapper
            .tareaConfiguracionChallengeDiasMinimosDtoToTareaConfiguracionChallengeDiasMinimos(src));
  }

  @Override
  public void saveConfChDiasMinimosResultItemDto(
      @Valid @NotNull @NotEmpty final List<ConfChDiasMinimosResultItemDto> src,
      @Valid @NotNull final TareaDto tarea) {
    tareaConfiguracionChallengeDiasMinimosRepositoryCustom.save(
        tareaConfiguracionChallengeDiasMinimosMapper
            .confChDiasMinimosResultItemDtoToTareaConfiguracionChallengeDiasMinimos(src, tarea));
  }

}
