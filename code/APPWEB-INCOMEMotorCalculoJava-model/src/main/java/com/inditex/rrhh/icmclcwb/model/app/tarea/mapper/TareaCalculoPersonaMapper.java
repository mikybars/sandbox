package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaCalculoPersonaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCalculoPersona;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(TareaCalculoPersonaDecorator.class)
public abstract class TareaCalculoPersonaMapper {

  @Mapping(target = "idTarea", source = "tarea.id")
  public abstract TareaCalculoPersonaDto tareaCalculoPersonaToTareaCalculoPersonaDto(
      TareaCalculoPersona src);

  public abstract List<TareaCalculoPersonaDto> tareaCalculoPersonaToTareaCalculoPersonaDto(
      List<TareaCalculoPersona> src);

  @InheritInverseConfiguration
  @Mapping(target = "estado.nombre", ignore = true)
  @Mapping(target = "estado.peso", ignore = true)
  public abstract TareaCalculoPersona tareaCalculoPersonaDtoToTareaCalculoPersona(
      TareaCalculoPersonaDto src);

  public abstract List<TareaCalculoPersona> tareaCalculoPersonaDtoToTareaCalculoPersona(
      List<TareaCalculoPersonaDto> src);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "tarea.id", source = "src.idTarea")
  @Mapping(target = "cclIdPerson", source = "src.cclIdPerson")
  @Mapping(target = "stdOrHrPeriod", source = "src.stdOrHrPeriod")
  @Mapping(target = "cclIdOrigen", source = "src.cclIdOrigen")
  @Mapping(target = "estado.id", source = "estado.id")
  public abstract TareaCalculoPersona tareaCalculoPersonaDtoToTareaCalculoPersona(
      TareaCalculoPersonaDto src, EstadoTareaPersonaDto estado);

  public List<TareaCalculoPersona> tareaCalculoPersonaDtoToTareaCalculoPersona(
      final List<TareaCalculoPersonaDto> src, final EstadoTareaPersonaDto estado) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
