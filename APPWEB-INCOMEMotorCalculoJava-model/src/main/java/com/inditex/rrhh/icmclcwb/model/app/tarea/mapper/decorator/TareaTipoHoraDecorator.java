package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTipoHoraMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTipoHora;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaTipoHoraDecorator extends TareaTipoHoraMapper {

  @Autowired
  private TareaTipoHoraMapper delegate;

  @Override
  public List<TareaTipoHora> tiposHorasResponseDtoToTareaTipoHora(
      final TiposHoraResponseDto src,
      final TareaDto tarea) {
    final List<TareaTipoHora> result = new ArrayList<>();
    if (src != null && CollectionUtils.isNotEmpty(src.getItems())) {
      src.getItems().forEach(item -> result.add(this.delegate.tipoHoraResultItemDtoToTareaTipoHora(item, tarea)));
    }
    return result;
  }

}
