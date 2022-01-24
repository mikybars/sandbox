package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoEmpresaDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.decorator.ProgramacionAmbitoEmpresaMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoEmpresa;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(value = ProgramacionAmbitoEmpresaMapperDecorator.class)
public abstract class ProgramacionAmbitoEmpresaMapper {

  @Mapping(target = "idProgramacionAmbito", source = "programacionAmbito.id")
  public abstract ProgramacionAmbitoEmpresaDTO programacionAmbitoEmpresaToProgramacionAmbitoEmpresaDto(
      ProgramacionAmbitoEmpresa src);

  public abstract List<ProgramacionAmbitoEmpresaDTO> programacionAmbitoEmpresaToProgramacionAmbitoEmpresaDto(
      List<ProgramacionAmbitoEmpresa> src);

  @InheritInverseConfiguration
  public abstract ProgramacionAmbitoEmpresa programacionAmbitoEmpresaDtoToProgramacionAmbitoEmpresa(
      ProgramacionAmbitoEmpresaDTO src);

  public abstract List<ProgramacionAmbitoEmpresa> programacionAmbitoEmpresaDtoToProgramacionAmbitoEmpresa(
      List<ProgramacionAmbitoEmpresaDTO> src);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "programacionAmbito.id", source = "srcProgramacionAmbito.id")
  public abstract ProgramacionAmbitoEmpresa mergeProgramacionAmbitoEmpresaDtoAndProgramacionDtoToProgramacionAmbitoEmpresa(
      ProgramacionAmbitoEmpresaDTO srcProgramacionAmbitoEmpresa, ProgramacionAmbitoDTO srcProgramacionAmbito);

  public List<ProgramacionAmbitoEmpresa> mergeProgramacionAmbitoEmpresaDtoAndProgramacionDtoToProgramacionAmbitoEmpresa(
      final List<ProgramacionAmbitoEmpresaDTO> srcProgramacionAmbitoEmpresa,
      final ProgramacionAmbitoDTO srcProgramacionAmbito) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
