package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoPersonaDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.decorator.ProgramacionAmbitoPersonaMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoPersona;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(value = ProgramacionAmbitoPersonaMapperDecorator.class)
public abstract class ProgramacionAmbitoPersonaMapper {

  @Mapping(target = "idProgramacionAmbito", source = "programacionAmbito.id")
  public abstract ProgramacionAmbitoPersonaDTO programacionAmbitoPersonaToProgramacionAmbitoPersonaDto(
      ProgramacionAmbitoPersona src);

  public abstract List<ProgramacionAmbitoPersonaDTO> programacionAmbitoPersonaToProgramacionAmbitoPersonaDto(
      List<ProgramacionAmbitoPersona> src);

  @InheritInverseConfiguration
  public abstract ProgramacionAmbitoPersona programacionAmbitoPersonaDtoToProgramacionAmbitoPersona(
      ProgramacionAmbitoPersonaDTO src);

  public abstract List<ProgramacionAmbitoPersona> programacionAmbitoPersonaDtoToProgramacionAmbitoPersona(
      List<ProgramacionAmbitoPersonaDTO> src);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "programacionAmbito.id", source = "srcProgramacionAmbito.id")
  public abstract ProgramacionAmbitoPersona mergeProgramacionAmbitoPersonaDtoAndProgramacionDtoToProgramacionAmbitoPersona(
      ProgramacionAmbitoPersonaDTO srcProgramacionAmbitoPersona, ProgramacionAmbitoDTO srcProgramacionAmbito);

  public List<ProgramacionAmbitoPersona> mergeProgramacionAmbitoPersonaDtoAndProgramacionDtoToProgramacionAmbitoPersona(
      final List<ProgramacionAmbitoPersonaDTO> srcProgramacionAmbitoPersona,
      final ProgramacionAmbitoDTO srcProgramacionAmbito) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
