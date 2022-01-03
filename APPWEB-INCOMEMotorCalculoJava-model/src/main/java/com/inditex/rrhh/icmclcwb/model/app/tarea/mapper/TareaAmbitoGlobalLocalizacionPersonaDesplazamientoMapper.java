package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalLocalizacionPersonaDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoGlobalLocalizacionPersonaDesplazamientoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersonaDesplazamiento;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(TareaAmbitoGlobalLocalizacionPersonaDesplazamientoDecorator.class)
public abstract class TareaAmbitoGlobalLocalizacionPersonaDesplazamientoMapper {

  @Mapping(target = "idTarea", source = "tarea.id")
  public abstract TareaAmbitoGlobalLocalizacionPersonaDesplazamientoDto tareaAmbitoGlobalLocalizacionPersonaDesplazamientoToTareaAmbitoGlobalLocalizacionPersonaDesplazamientoDto(
      TareaAmbitoGlobalLocalizacionPersonaDesplazamiento src);

  public abstract List<TareaAmbitoGlobalLocalizacionPersonaDesplazamientoDto> tareaAmbitoGlobalLocalizacionPersonaDesplazamientoToTareaAmbitoGlobalLocalizacionPersonaDesplazamientoDto(
      List<TareaAmbitoGlobalLocalizacionPersonaDesplazamiento> src);

  @InheritInverseConfiguration
  public abstract TareaAmbitoGlobalLocalizacionPersonaDesplazamiento tareaAmbitoGlobalLocalizacionPersonaDesplazamientoDtoToTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(
      TareaAmbitoGlobalLocalizacionPersonaDesplazamientoDto src);

  public abstract List<TareaAmbitoGlobalLocalizacionPersonaDesplazamiento> tareaAmbitoGlobalLocalizacionPersonaDesplazamientoDtoToTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(
      List<TareaAmbitoGlobalLocalizacionPersonaDesplazamientoDto> src);

  @Mapping(source = "src.idOrigen", target = "cclIdOrigen")
  @Mapping(source = "src.idLugarTrabajo", target = "stdIdWorkLocat")
  @Mapping(source = "src.idEmpresa", target = "stdIdLegEnt")
  @Mapping(source = "tareaDto.id", target = "tarea.id")
  @Mapping(source = "src.idEmpleadoLocal", target = "cclIdPerson")
  @Mapping(target = "id", ignore = true)
  public abstract TareaAmbitoGlobalLocalizacionPersonaDesplazamiento genericEmpleadoResultItemDtoToTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(
      GenericEmpleadoResultItemDto src, TareaDto tareaDto);

  public List<TareaAmbitoGlobalLocalizacionPersonaDesplazamiento> genericEmpleadoResultItemDtoToTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(
      final List<GenericEmpleadoResultItemDto> src, final TareaDto tareaDto) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
