package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoEmpresaDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoEmpresaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoEmpresa;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class ProgramacionAmbitoEmpresaMapperDecorator extends ProgramacionAmbitoEmpresaMapper {

  @Autowired
  private ProgramacionAmbitoEmpresaMapper delegate;

  @Override
  public List<ProgramacionAmbitoEmpresa> mergeProgramacionAmbitoEmpresaDtoAndProgramacionDtoToProgramacionAmbitoEmpresa(
      final List<ProgramacionAmbitoEmpresaDTO> srcProgramacionAmbitoEmpresa,
      final ProgramacionAmbitoDTO srcProgramacionAmbito) {
    final List<ProgramacionAmbitoEmpresa> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(srcProgramacionAmbitoEmpresa)) {
      srcProgramacionAmbitoEmpresa.forEach(item -> result
          .add(this.delegate.mergeProgramacionAmbitoEmpresaDtoAndProgramacionDtoToProgramacionAmbitoEmpresa(item,
              srcProgramacionAmbito)));
    }
    return result;
  }

}
