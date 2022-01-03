package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Fase;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class FaseMapper {

  @Mapping(target = "id", source = "id")
  public abstract FaseDto faseToFaseDto(
      Fase src);

  public abstract List<FaseDto> faseToFaseDto(
      List<Fase> src);

  @InheritInverseConfiguration
  public abstract Fase faseDtoToFase(
      FaseDto src);

  public abstract List<Fase> faseDtoToFase(
      List<FaseDto> src);

}
