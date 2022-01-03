package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoPersonaMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoPersona;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(value = TareaAmbitoPersonaMapperDecorator.class)
public abstract class TareaAmbitoPersonaMapper {

  @Mapping(target = "idTarea", source = "tarea.id")
  public abstract TareaAmbitoPersonaDto tareaAmbitoPersonaToTareaAmbitoPersonaDto(TareaAmbitoPersona src);

  public abstract List<TareaAmbitoPersonaDto> tareaAmbitoPersonaToTareaAmbitoPersonaDto(
      List<TareaAmbitoPersona> src);

  @InheritInverseConfiguration
  public abstract TareaAmbitoPersona tareaAmbitoPersonaDtoToTareaAmbitoPersona(TareaAmbitoPersonaDto src);

  public abstract List<TareaAmbitoPersona> tareaAmbitoPersonaDtoToTareaAmbitoPersona(
      List<TareaAmbitoPersonaDto> src);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "tarea.id", source = "srcTarea.id")
  public abstract TareaAmbitoPersona mergeTareaAmbitoPersonaDtoAndTareaDtoToTareaAmbitoPersona(
      TareaAmbitoPersonaDto srcTareaAmbitoPersona, TareaDto srcTarea);

  public List<TareaAmbitoPersona> mergeTareaAmbitoPersonaDtoAndTareaDtoToTareaAmbitoPersona(
      List<TareaAmbitoPersonaDto> srcTareaAmbitoPersona, TareaDto srcTarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
