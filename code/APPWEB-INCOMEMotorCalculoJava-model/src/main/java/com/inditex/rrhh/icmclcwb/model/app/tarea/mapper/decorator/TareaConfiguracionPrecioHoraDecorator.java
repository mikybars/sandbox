package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaConfiguracionPrecioHoraMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracionPrecioHora;
import com.inditex.rrhh.icmclcwb.rest.client.dto.ConfiguracionPrecioHoraResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaConfiguracionPrecioHoraDecorator extends TareaConfiguracionPrecioHoraMapper {

  @Autowired
  private TareaConfiguracionPrecioHoraMapper delegate;

  @Override
  public List<TareaConfiguracionPrecioHora> configuracionPrecioHoraResponseDTOToTareaConfiguracionPrecioHora(
      final List<ConfiguracionPrecioHoraResponseDTO> src, final TareaDto tarea) {
    final ArrayList<TareaConfiguracionPrecioHora> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(item -> result
          .add(this.delegate.configuracionPrecioHoraResponseDTOToTareaConfiguracionPrecioHora(item, tarea)));
    }
    return result;
  }

}
