package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoLocalizacion;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaAmbitoLocalizacionMapperDecorator extends TareaAmbitoLocalizacionMapper {

  @Autowired
  private TareaAmbitoLocalizacionMapper delegate;

  @Override
  public List<TareaAmbitoLocalizacion> mergeTareaAmbitoLocalizacionDtoAndTareaDtoToTareaAmbitoLocalizacion(
      List<TareaAmbitoLocalizacionDto> srcTareaAmbitoLocalizacion, TareaDto srcTarea) {
    List<TareaAmbitoLocalizacion> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(srcTareaAmbitoLocalizacion)) {
      srcTareaAmbitoLocalizacion.forEach(item -> result
          .add(delegate.mergeTareaAmbitoLocalizacionDtoAndTareaDtoToTareaAmbitoLocalizacion(item, srcTarea)));
    }
    return result;
  }

}
