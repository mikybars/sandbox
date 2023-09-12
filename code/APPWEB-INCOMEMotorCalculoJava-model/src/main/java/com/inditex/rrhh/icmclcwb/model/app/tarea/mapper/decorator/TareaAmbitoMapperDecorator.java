package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbito;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaAmbitoMapperDecorator extends TareaAmbitoMapper {

  @Autowired
  private TareaAmbitoMapper delegate;

  @Override
  public List<TareaAmbito> mergeTareaAmbitoDtoAndTareaDtoToTareaAmbito(
      List<TareaAmbitoDto> srcTareaAmbito, TareaDto srcTarea) {
    List<TareaAmbito> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(srcTareaAmbito)) {
      srcTareaAmbito.forEach(item -> result
          .add(delegate.mergeTareaAmbitoDtoAndTareaDtoToTareaAmbito(item, srcTarea)));
    }
    return result;
  }

}
