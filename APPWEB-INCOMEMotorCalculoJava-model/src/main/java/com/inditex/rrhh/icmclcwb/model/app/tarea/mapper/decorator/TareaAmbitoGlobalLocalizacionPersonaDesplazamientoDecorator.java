package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoGlobalLocalizacionPersonaDesplazamientoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersonaDesplazamiento;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaAmbitoGlobalLocalizacionPersonaDesplazamientoDecorator
    extends TareaAmbitoGlobalLocalizacionPersonaDesplazamientoMapper {

  @Autowired
  private TareaAmbitoGlobalLocalizacionPersonaDesplazamientoMapper delegate;

  @Override
  public List<TareaAmbitoGlobalLocalizacionPersonaDesplazamiento> genericEmpleadoResultItemDtoToTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(
      List<GenericEmpleadoResultItemDto> src, TareaDto tareaDto) {
    List<TareaAmbitoGlobalLocalizacionPersonaDesplazamiento> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      for (GenericEmpleadoResultItemDto item : src) {
        result.add(delegate
            .genericEmpleadoResultItemDtoToTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(item, tareaDto));
      }
    }
    return result;
  }

}
