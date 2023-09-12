package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaLocalizacionHistoricoDecorator extends TareaLocalizacionHistoricoMapper {

  @Autowired
  private TareaLocalizacionHistoricoMapper delegate;

  @Override
  public List<TareaLocalizacionHistoricoDto> genericLocalizacionResultItemDtoToTareaLocalizacionHistoricoDto(
      List<GenericTiendaResultItemDto> src, TareaDto srcTarea) {
    List<TareaLocalizacionHistoricoDto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(item -> result.add(
          delegate.genericLocalizacionResultItemDtoToTareaLocalizacionHistoricoDto(item, srcTarea)));
    }
    return result;
  }

}
