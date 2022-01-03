package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseAccionDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.FaseAccion;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class FaseAccionMapper {

  @Mapping(target = "idFase", source = "pk.fase.id")
  @Mapping(target = "idAccion", source = "pk.accion.id")
  @Mapping(target = "idPuntoEjecucion", source = "puntoEjecucion.id")
  public abstract FaseAccionDto faseAccionToFaseAccionDto(
      FaseAccion src);

  public abstract List<FaseAccionDto> faseAccionToFaseAccionDto(
      List<FaseAccion> src);

  @InheritInverseConfiguration
  public abstract FaseAccion faseAccionDtoToFaseAccion(
      FaseAccionDto src);

  public abstract List<FaseAccion> faseAccionDtoToFaseAccion(
      List<FaseAccionDto> src);

}
