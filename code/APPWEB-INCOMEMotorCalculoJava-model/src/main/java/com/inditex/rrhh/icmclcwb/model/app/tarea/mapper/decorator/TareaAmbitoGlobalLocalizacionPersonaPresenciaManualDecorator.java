package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoGlobalLocalizacionPersonaPresenciaManualMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersonaPresenciaManual;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaAmbitoGlobalLocalizacionPersonaPresenciaManualDecorator
    extends TareaAmbitoGlobalLocalizacionPersonaPresenciaManualMapper {

  @Autowired
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaManualMapper delegate;

  @Override
  public List<TareaAmbitoGlobalLocalizacionPersonaPresenciaManual> genericEmpleadoResultItemDtoToTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(
      List<GenericEmpleadoResultItemDto> src, TareaDto tareaDto) {
    List<TareaAmbitoGlobalLocalizacionPersonaPresenciaManual> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      for (GenericEmpleadoResultItemDto item : src) {
        result.add(delegate
            .genericEmpleadoResultItemDtoToTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(item, tareaDto));
      }
    }
    return result;
  }

}
