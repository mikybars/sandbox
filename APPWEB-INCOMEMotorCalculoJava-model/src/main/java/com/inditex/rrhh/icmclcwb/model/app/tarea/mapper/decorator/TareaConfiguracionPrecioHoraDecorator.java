package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaConfiguracionPrecioHoraMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracionPrecioHora;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaConfiguracionPrecioHoraDecorator extends TareaConfiguracionPrecioHoraMapper {

  @Autowired
  private TareaConfiguracionPrecioHoraMapper delegate;

  @Override
  public List<TareaConfiguracionPrecioHora> confPrecioHoraResultItemDtoToTareaConfiguracionPrecioHora(
      List<ConfPrecioHoraResultItemDto> src, TareaDto tarea) {
    ArrayList<TareaConfiguracionPrecioHora> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(item -> result
          .add(delegate.confPrecioHoraResultItemDtoToTareaConfiguracionPrecioHora(item, tarea)));
    }
    return result;
  }

}
