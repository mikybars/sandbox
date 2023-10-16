package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionEstadoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaLocalizacionEstadoDecorator extends TareaLocalizacionEstadoMapper {
  @Autowired
  private TareaLocalizacionEstadoMapper delegate;

  @Override
  public List<TareaLocalizacionEstadoDto> estadoWlocResultItemDtoToTareaLocalizacionEstadoDto(
      final List<EstadoWlocResultItemDto> src, final TareaDto srcTarea) {
    final List<TareaLocalizacionEstadoDto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(item -> result.add(
          this.delegate.estadoWlocResultItemDtoToTareaLocalizacionEstadoDto(item, srcTarea)));
    }
    return result;
  }

}
