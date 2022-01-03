package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoPersonaDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoPersona;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class ProgramacionAmbitoPersonaMapperDecorator extends ProgramacionAmbitoPersonaMapper {

  @Autowired
  private ProgramacionAmbitoPersonaMapper delegate;

  @Override
  public List<ProgramacionAmbitoPersona> mergeProgramacionAmbitoPersonaDtoAndProgramacionDtoToProgramacionAmbitoPersona(
      final List<ProgramacionAmbitoPersonaDTO> srcProgramacionAmbitoPersona,
      final ProgramacionAmbitoDTO srcProgramacionAmbito) {
    final List<ProgramacionAmbitoPersona> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(srcProgramacionAmbitoPersona)) {
      srcProgramacionAmbitoPersona.forEach(item -> result
          .add(this.delegate.mergeProgramacionAmbitoPersonaDtoAndProgramacionDtoToProgramacionAmbitoPersona(item,
              srcProgramacionAmbito)));
    }
    return result;
  }

}
