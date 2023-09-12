package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoLocalizacionDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoLocalizacion;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class ProgramacionAmbitoLocalizacionMapperDecorator extends ProgramacionAmbitoLocalizacionMapper {

  @Autowired
  private ProgramacionAmbitoLocalizacionMapper delegate;

  @Override
  public List<ProgramacionAmbitoLocalizacion> mergeProgramacionAmbitoLocalizacionDtoAndProgramacionDtoToProgramacionAmbitoLocalizacion(
      final List<ProgramacionAmbitoLocalizacionDTO> srcProgramacionAmbitoLocalizacion,
      final ProgramacionAmbitoDTO srcProgramacionAmbito) {
    final List<ProgramacionAmbitoLocalizacion> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(srcProgramacionAmbitoLocalizacion)) {
      srcProgramacionAmbitoLocalizacion.forEach(item -> result
          .add(this.delegate
              .mergeProgramacionAmbitoLocalizacionDtoAndProgramacionDtoToProgramacionAmbitoLocalizacion(
                  item,
                  srcProgramacionAmbito)));
    }
    return result;
  }

}
