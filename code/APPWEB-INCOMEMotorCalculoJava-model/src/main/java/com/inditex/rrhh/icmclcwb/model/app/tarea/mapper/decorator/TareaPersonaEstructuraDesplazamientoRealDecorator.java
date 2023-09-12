package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraDesplazamientoRealMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamientoReal;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaPersonaEstructuraDesplazamientoRealDecorator
    extends TareaPersonaEstructuraDesplazamientoRealMapper {

  @Autowired
  private TareaPersonaEstructuraDesplazamientoRealMapper delegate;

  @Override
  public List<TareaPersonaEstructuraDesplazamientoReal> desplazamientoRealResultItemDtoToTareaPersonaEstructuraDesplazamientoReal(
      final List<DesplazamientoRealResultItemDto> src, final TareaDto tarea) {
    final List<TareaPersonaEstructuraDesplazamientoReal> result = new ArrayList<>();
    src.forEach(x -> result
        .add(this.delegate.desplazamientoRealResultItemDtoToTareaPersonaEstructuraDesplazamientoReal(x, tarea)));
    return result;
  }

}
