package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoEmpresaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoEmpresaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoAmbitoEmpresa;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TrabajoAmbitoEmpresaMapperDecorator extends TrabajoAmbitoEmpresaMapper {

  @Autowired
  private TrabajoAmbitoEmpresaMapper delegate;

  @Override
  public List<TrabajoAmbitoEmpresa> mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTrabajoAmbitoEmpresa(
      final List<TrabajoAmbitoEmpresaDTO> srcTrabajoAmbitoEmpresa, final TrabajoDTO srcTrabajo) {
    final List<TrabajoAmbitoEmpresa> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(srcTrabajoAmbitoEmpresa)) {
      srcTrabajoAmbitoEmpresa.forEach(item -> result
          .add(this.delegate.mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTrabajoAmbitoEmpresa(item, srcTrabajo)));
    }
    return result;
  }

}
