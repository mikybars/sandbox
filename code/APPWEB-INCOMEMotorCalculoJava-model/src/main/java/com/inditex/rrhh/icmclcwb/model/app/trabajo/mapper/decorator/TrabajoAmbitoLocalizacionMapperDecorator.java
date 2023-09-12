package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoLocalizacionDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoAmbitoLocalizacion;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TrabajoAmbitoLocalizacionMapperDecorator extends TrabajoAmbitoLocalizacionMapper {

  @Autowired
  private TrabajoAmbitoLocalizacionMapper delegate;

  @Override
  public List<TrabajoAmbitoLocalizacion> mergeTrabajoAmbitoLocalizacionDtoAndTrabajoDtoToTrabajoAmbitoLocalizacion(
      final List<TrabajoAmbitoLocalizacionDTO> srcTrabajoAmbitoLocalizacion, final TrabajoDTO srcTrabajo) {
    final List<TrabajoAmbitoLocalizacion> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(srcTrabajoAmbitoLocalizacion)) {
      srcTrabajoAmbitoLocalizacion.forEach(item -> result.add(this.delegate
          .mergeTrabajoAmbitoLocalizacionDtoAndTrabajoDtoToTrabajoAmbitoLocalizacion(item, srcTrabajo)));
    }
    return result;
  }

}
