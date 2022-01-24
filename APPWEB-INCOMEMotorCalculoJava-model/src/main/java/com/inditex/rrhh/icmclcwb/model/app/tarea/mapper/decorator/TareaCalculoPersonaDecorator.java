package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaCalculoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCalculoPersona;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaCalculoPersonaDecorator extends TareaCalculoPersonaMapper {

  @Autowired
  private TareaCalculoPersonaMapper delegate;

  @Override
  public List<TareaCalculoPersona> tareaCalculoPersonaDtoToTareaCalculoPersona(
      List<TareaCalculoPersonaDto> src, EstadoTareaPersonaDto estado) {
    List<TareaCalculoPersona> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(item -> result
          .add(delegate.tareaCalculoPersonaDtoToTareaCalculoPersona(item, estado)));
    }
    return result;
  }

}
