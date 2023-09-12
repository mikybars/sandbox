package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoPersona;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaAmbitoPersonaMapperDecorator extends TareaAmbitoPersonaMapper {

  @Autowired
  private TareaAmbitoPersonaMapper delegate;

  @Override
  public List<TareaAmbitoPersona> mergeTareaAmbitoPersonaDtoAndTareaDtoToTareaAmbitoPersona(
      List<TareaAmbitoPersonaDto> srcTareaAmbitoPersona, TareaDto srcTarea) {
    List<TareaAmbitoPersona> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(srcTareaAmbitoPersona)) {
      srcTareaAmbitoPersona.forEach(item -> result
          .add(delegate.mergeTareaAmbitoPersonaDtoAndTareaDtoToTareaAmbitoPersona(item, srcTarea)));
    }
    return result;
  }

}
