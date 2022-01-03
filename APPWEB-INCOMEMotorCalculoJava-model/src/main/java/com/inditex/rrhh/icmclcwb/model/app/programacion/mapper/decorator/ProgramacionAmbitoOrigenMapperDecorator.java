package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoOrigenDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoOrigenMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoOrigen;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class ProgramacionAmbitoOrigenMapperDecorator extends ProgramacionAmbitoOrigenMapper {

  @Autowired
  private ProgramacionAmbitoOrigenMapper delegate;

  @Override
  public List<ProgramacionAmbitoOrigen> mergeProgramacionAmbitoOrigenDtoAndProgramacionDtoToProgramacionAmbitoOrigen(
      final List<ProgramacionAmbitoOrigenDTO> srcProgramacionAmbitoOrigen,
      final ProgramacionAmbitoDTO srcProgramacionAmbito) {
    final List<ProgramacionAmbitoOrigen> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(srcProgramacionAmbitoOrigen)) {
      srcProgramacionAmbitoOrigen.forEach(item -> result
          .add(this.delegate.mergeProgramacionAmbitoOrigenDtoAndProgramacionDtoToProgramacionAmbitoOrigen(item,
              srcProgramacionAmbito)));
    }
    return result;
  }

}
