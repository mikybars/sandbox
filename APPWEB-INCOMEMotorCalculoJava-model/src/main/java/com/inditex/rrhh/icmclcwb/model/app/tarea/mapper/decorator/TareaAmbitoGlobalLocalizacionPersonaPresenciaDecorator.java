package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoGlobalLocalizacionPersonaPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersonaPresencia;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaAmbitoGlobalLocalizacionPersonaPresenciaDecorator
    extends TareaAmbitoGlobalLocalizacionPersonaPresenciaMapper {

  @Autowired
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaMapper delegate;

  @Override
  public List<TareaAmbitoGlobalLocalizacionPersonaPresencia> presenciaEmpleadosTiendaResultItemDtoToTareaLocalizacionPersonaPresencia(
      List<PtrPresenciaEmpleadosTiendaResultItemDto> src, TareaDto tareaDto) {
    List<TareaAmbitoGlobalLocalizacionPersonaPresencia> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      for (PtrPresenciaEmpleadosTiendaResultItemDto item : src) {
        for (Integer persona : item.getPersonas()) {
          result.add(delegate.presenciaEmpleadosTiendaResultItemDtoToTareaLocalizacionPersonaPresencia(
              persona, item, tareaDto));
        }
      }
    }
    return result;
  }

}
