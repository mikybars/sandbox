package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaCoeficienteMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaCoeficiente;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaPersonaCoeficienteDecorator extends TareaPersonaCoeficienteMapper {

  @Autowired
  private TareaPersonaCoeficienteMapper delegate;

  @Override
  public List<TareaPersonaCoeficiente> genericEmpleadoResultItemDtoToTareaPersonaCoeficiente(
      final List<GenericEmpleadoResultItemDto> srcTareaPersonaHistorico, final TareaDto srcTarea) {
    final List<TareaPersonaCoeficiente> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(srcTareaPersonaHistorico)) {
      srcTareaPersonaHistorico.stream().filter(s -> Double.valueOf(s.getCoefJornada()) < 1).forEach(e -> e.setCoefJornada("0"));
      srcTareaPersonaHistorico.stream()
          .forEach(item -> result.add(
              this.delegate.genericEmpleadoResultItemDtoToTareaPersonaCoeficiente(item, srcTarea)));
    }
    return result;
  }

}
