package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalLocalizacionDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacion;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TareaLocalizacionMapper {

  @Mapping(target = "idTarea", source = "tarea.id")
  public abstract TareaAmbitoGlobalLocalizacionDto tareaLocalizacionToTareaLocalizacionDto(
      TareaAmbitoGlobalLocalizacion src);

  public abstract List<TareaAmbitoGlobalLocalizacionDto> tareaLocalizacionToTareaLocalizacionDto(
      List<TareaAmbitoGlobalLocalizacion> src);

  @InheritInverseConfiguration
  public abstract TareaAmbitoGlobalLocalizacion tareaLocalizacionDtoToTareaLocalizacion(
      TareaAmbitoGlobalLocalizacionDto src);

  public abstract List<TareaAmbitoGlobalLocalizacion> tareaLocalizacionDtoToTareaLocalizacion(
      List<TareaAmbitoGlobalLocalizacionDto> src);

}
