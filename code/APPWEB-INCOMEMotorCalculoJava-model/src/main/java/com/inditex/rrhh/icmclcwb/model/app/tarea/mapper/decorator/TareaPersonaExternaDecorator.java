package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaExternaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaExterna;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaPersonaExternaDecorator extends TareaPersonaExternaMapper {

  @Autowired
  private TareaPersonaExternaMapper delegate;

  @Override
  public List<TareaPersonaExterna> idPersonaLocalExternaToTareaPersonaExterna(
      final List<IdPersonaLocalExternaDto> src,
      final TareaDto tarea) {
    final List<TareaPersonaExterna> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(x -> result.add(this.delegate.idPersonaLocalExternaToTareaPersonaExterna(x, tarea)));
    }
    return result;
  }

}
