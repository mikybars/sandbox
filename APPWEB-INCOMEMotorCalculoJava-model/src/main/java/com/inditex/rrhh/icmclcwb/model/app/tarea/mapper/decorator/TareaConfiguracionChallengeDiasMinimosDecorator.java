package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaConfiguracionChallengeDiasMinimosMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracionChallengeDiasMinimos;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaConfiguracionChallengeDiasMinimosDecorator
    extends TareaConfiguracionChallengeDiasMinimosMapper {

  @Autowired
  private TareaConfiguracionChallengeDiasMinimosMapper delegate;

  @Override
  public List<TareaConfiguracionChallengeDiasMinimos> confChDiasMinimosResultItemDtoToTareaConfiguracionChallengeDiasMinimos(
      List<ConfChDiasMinimosResultItemDto> src, TareaDto tarea) {
    ArrayList<TareaConfiguracionChallengeDiasMinimos> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(item -> result
          .add(delegate.confChDiasMinimosResultItemDtoToTareaConfiguracionChallengeDiasMinimos(item, tarea)));
    }
    return result;
  }

}
