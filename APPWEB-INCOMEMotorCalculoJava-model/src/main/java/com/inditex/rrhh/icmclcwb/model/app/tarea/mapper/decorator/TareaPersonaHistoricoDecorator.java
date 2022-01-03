package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaHistoricoMapper;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaPersonaHistoricoDecorator extends TareaPersonaHistoricoMapper {

  @Autowired
  private TareaPersonaHistoricoMapper delegate;

  @Override
  public List<TareaPersonaHistoricoDto> genericEmpleadoResultItemDtoToTareaPersonaHistoricoDto(
      List<GenericEmpleadoResultItemDto> src, TareaDto tarea) {
    List<TareaPersonaHistoricoDto> result = new ArrayList<>();
    src.forEach(x -> result.add(delegate.genericEmpleadoResultItemDtoToTareaPersonaHistoricoDto(x, tarea)));
    return result;
  }

}
