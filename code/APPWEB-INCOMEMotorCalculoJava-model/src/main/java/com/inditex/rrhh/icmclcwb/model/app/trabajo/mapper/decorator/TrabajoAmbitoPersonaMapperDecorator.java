package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoPersonaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoAmbitoPersona;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TrabajoAmbitoPersonaMapperDecorator extends TrabajoAmbitoPersonaMapper {

  @Autowired
  private TrabajoAmbitoPersonaMapper delegate;

  @Override
  public List<TrabajoAmbitoPersona> mergeTrabajoAmbitoPersonaDtoAndTrabajoDtoToTrabajoAmbitoPersona(
      final List<TrabajoAmbitoPersonaDTO> srcTrabajoAmbitoPersona, final TrabajoDTO srcTrabajo) {
    final List<TrabajoAmbitoPersona> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(srcTrabajoAmbitoPersona)) {
      srcTrabajoAmbitoPersona.forEach(item -> result
          .add(this.delegate.mergeTrabajoAmbitoPersonaDtoAndTrabajoDtoToTrabajoAmbitoPersona(item, srcTrabajo)));
    }
    return result;
  }

}
