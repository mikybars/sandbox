package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoOrigenDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoOrigenMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoAmbitoOrigen;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TrabajoAmbitoOrigenMapperDecorator extends TrabajoAmbitoOrigenMapper {

  @Autowired
  private TrabajoAmbitoOrigenMapper delegate;

  @Override
  public List<TrabajoAmbitoOrigen> mergeTrabajoAmbitoOrigenDtoAndTrabajoDtoToTrabajoAmbitoOrigen(
      final List<TrabajoAmbitoOrigenDTO> srcTrabajoAmbitoOrigen, final TrabajoDTO srcTrabajo) {
    final List<TrabajoAmbitoOrigen> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(srcTrabajoAmbitoOrigen)) {
      srcTrabajoAmbitoOrigen.forEach(item -> result
          .add(this.delegate.mergeTrabajoAmbitoOrigenDtoAndTrabajoDtoToTrabajoAmbitoOrigen(item, srcTrabajo)));
    }
    return result;
  }

}
