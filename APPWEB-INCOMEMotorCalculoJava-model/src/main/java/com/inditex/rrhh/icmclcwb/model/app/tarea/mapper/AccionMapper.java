package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Accion;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class AccionMapper {

  @Mapping(target = "id", source = "id")
  @Mapping(target = "nombre", source = "nombre")
  public abstract AccionDto accionToAccionDto(
      Accion src);

  public abstract List<AccionDto> accionToAccionDto(
      List<Accion> src);

  @InheritInverseConfiguration
  public abstract Accion accionDtoToAccion(
      AccionDto src);

  public abstract List<Accion> accionDtoToAccion(
      List<AccionDto> src);

}
