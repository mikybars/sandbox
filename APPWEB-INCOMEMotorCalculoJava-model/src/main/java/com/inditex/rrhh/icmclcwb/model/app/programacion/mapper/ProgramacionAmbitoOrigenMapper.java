package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoOrigenDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.decorator.ProgramacionAmbitoOrigenMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoOrigen;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(value = ProgramacionAmbitoOrigenMapperDecorator.class)
public abstract class ProgramacionAmbitoOrigenMapper {

  @Mapping(target = "idProgramacionAmbito", source = "programacionAmbito.id")
  public abstract ProgramacionAmbitoOrigenDTO programacionAmbitoOrigenToProgramacionAmbitoOrigenDto(
      ProgramacionAmbitoOrigen src);

  public abstract List<ProgramacionAmbitoOrigenDTO> programacionAmbitoOrigenToProgramacionAmbitoOrigenDto(
      List<ProgramacionAmbitoOrigen> src);

  @InheritInverseConfiguration
  public abstract ProgramacionAmbitoOrigen programacionAmbitoOrigenDtoToProgramacionAmbitoOrigen(
      ProgramacionAmbitoOrigenDTO src);

  public abstract List<ProgramacionAmbitoOrigen> programacionAmbitoOrigenDtoToProgramacionAmbitoOrigen(
      List<ProgramacionAmbitoOrigenDTO> src);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "programacionAmbito.id", source = "srcProgramacionAmbito.id")
  public abstract ProgramacionAmbitoOrigen mergeProgramacionAmbitoOrigenDtoAndProgramacionDtoToProgramacionAmbitoOrigen(
      ProgramacionAmbitoOrigenDTO srcProgramacionAmbitoOrigen, ProgramacionAmbitoDTO srcProgramacionAmbito);

  public List<ProgramacionAmbitoOrigen> mergeProgramacionAmbitoOrigenDtoAndProgramacionDtoToProgramacionAmbitoOrigen(
      final List<ProgramacionAmbitoOrigenDTO> srcProgramacionAmbitoOrigen,
      final ProgramacionAmbitoDTO srcProgramacionAmbito) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
