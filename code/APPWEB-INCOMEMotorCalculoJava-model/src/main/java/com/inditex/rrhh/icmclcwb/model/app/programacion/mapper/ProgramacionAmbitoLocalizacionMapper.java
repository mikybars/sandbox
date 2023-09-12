package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoLocalizacionDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.decorator.ProgramacionAmbitoLocalizacionMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoLocalizacion;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(value = ProgramacionAmbitoLocalizacionMapperDecorator.class)
public abstract class ProgramacionAmbitoLocalizacionMapper {

  @Mapping(target = "idProgramacionAmbito", source = "programacionAmbito.id")
  public abstract ProgramacionAmbitoLocalizacionDTO programacionAmbitoLocalizacionToProgramacionAmbitoLocalizacionDto(
      ProgramacionAmbitoLocalizacion src);

  public abstract List<ProgramacionAmbitoLocalizacionDTO> programacionAmbitoLocalizacionToProgramacionAmbitoLocalizacionDto(
      List<ProgramacionAmbitoLocalizacion> src);

  @InheritInverseConfiguration
  public abstract ProgramacionAmbitoLocalizacion programacionAmbitoLocalizacionDtoToProgramacionAmbitoLocalizacion(
      ProgramacionAmbitoLocalizacionDTO src);

  public abstract List<ProgramacionAmbitoLocalizacion> programacionAmbitoLocalizacionDtoToProgramacionAmbitoLocalizacion(
      List<ProgramacionAmbitoLocalizacionDTO> src);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "programacionAmbito.id", source = "srcProgramacionAmbito.id")
  public abstract ProgramacionAmbitoLocalizacion mergeProgramacionAmbitoLocalizacionDtoAndProgramacionDtoToProgramacionAmbitoLocalizacion(
      ProgramacionAmbitoLocalizacionDTO srcProgramacionAmbitoLocalizacion,
      ProgramacionAmbitoDTO srcProgramacionAmbito);

  public List<ProgramacionAmbitoLocalizacion> mergeProgramacionAmbitoLocalizacionDtoAndProgramacionDtoToProgramacionAmbitoLocalizacion(
      final List<ProgramacionAmbitoLocalizacionDTO> srcProgramacionAmbitoLocalizacion,
      final ProgramacionAmbitoDTO srcProgramacionAmbito) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
