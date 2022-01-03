package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoLocalizacionMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoLocalizacion;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(value = TareaAmbitoLocalizacionMapperDecorator.class)
public abstract class TareaAmbitoLocalizacionMapper {

  @Mapping(target = "idTarea", source = "tarea.id")
  public abstract TareaAmbitoLocalizacionDto tareaAmbitoLocalizacionToTareaAmbitoLocalizacionDto(
      TareaAmbitoLocalizacion src);

  public abstract List<TareaAmbitoLocalizacionDto> tareaAmbitoLocalizacionToTareaAmbitoLocalizacionDto(
      List<TareaAmbitoLocalizacion> src);

  @InheritInverseConfiguration
  public abstract TareaAmbitoLocalizacion tareaAmbitoLocalizacionDtoToTareaAmbitoLocalizacion(
      TareaAmbitoLocalizacionDto src);

  public abstract List<TareaAmbitoLocalizacion> tareaAmbitoLocalizacionDtoToTareaAmbitoLocalizacion(
      List<TareaAmbitoLocalizacionDto> src);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "tarea.id", source = "srcTarea.id")
  public abstract TareaAmbitoLocalizacion mergeTareaAmbitoLocalizacionDtoAndTareaDtoToTareaAmbitoLocalizacion(
      TareaAmbitoLocalizacionDto srcTareaAmbitoLocalizacion, TareaDto srcTarea);

  public List<TareaAmbitoLocalizacion> mergeTareaAmbitoLocalizacionDtoAndTareaDtoToTareaAmbitoLocalizacion(
      List<TareaAmbitoLocalizacionDto> srcTareaAmbitoLocalizacion, TareaDto srcTarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
