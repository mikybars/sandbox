package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionCalcularMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionCalcular;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaLocalizacionCalcularDecorator extends TareaLocalizacionCalcularMapper {

  @Autowired
  private TareaLocalizacionCalcularMapper delegate;

  @Override
  public List<TareaLocalizacionCalcular> genericTiendaResultItemDtoToTareaLocalizacionCalcular(
      List<GenericTiendaResultItemDto> src, TareaDto tareaDto) {
    List<TareaLocalizacionCalcular> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(item -> result.add(
          delegate.genericTiendaResultItemDtoToTareaLocalizacionCalcular(item, tareaDto)));
    }
    return result;
  }

}
