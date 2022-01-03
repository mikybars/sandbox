package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFase;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TareaFaseMapper {

  @Mapping(target = "id", source = "id")
  @Mapping(target = "idTarea", source = "tarea.id")
  @Mapping(target = "idFase", source = "fase.id")
  @Mapping(target = "estadoTareaFase.id", source = "estadoTareaFase.id")
  public abstract TareaFaseDto tareaFaseToTareaFaseDto(
      TareaFase src);

  public abstract List<TareaFaseDto> tareaFaseToTareaFaseDto(
      List<TareaFase> src);

  @InheritInverseConfiguration
  public abstract TareaFase tareaFaseDtoToTareaFase(
      TareaFaseDto src);

  public abstract List<TareaFase> tareaFaseDtoToTareaFase(
      List<TareaFaseDto> src);

}
