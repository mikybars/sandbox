package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalFechaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoGlobalFechaMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalFecha;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(TareaAmbitoGlobalFechaMapperDecorator.class)
public abstract class TareaAmbitoGlobalFechaMapper {

  @Mapping(target = "tipoDato", ignore = true)
  @Mapping(target = "tarea.id", source = "idTarea")
  public abstract TareaAmbitoGlobalFecha tareaAmbitoGlobalFechaDtoToTareaAmbitoGlobalFecha(
      TareaAmbitoGlobalFechaDto src);

  public List<TareaAmbitoGlobalFecha> tareaAmbitoGlobalFechaDtoToTareaAmbitoGlobalFecha(
      final List<TareaAmbitoGlobalFechaDto> src, final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);

  }

  @InheritInverseConfiguration
  @Mapping(target = "idTarea", source = "tarea.id")
  public abstract TareaAmbitoGlobalFechaDto tareaAmbitoGlobalFechaToTareaAmbitoGlobalFechaDto(
      TareaAmbitoGlobalFecha src);

  public abstract List<TareaAmbitoGlobalFechaDto> tareaAmbitoGlobalFechaToTareaAmbitoGlobalFechaDto(
      List<TareaAmbitoGlobalFecha> src);

}
