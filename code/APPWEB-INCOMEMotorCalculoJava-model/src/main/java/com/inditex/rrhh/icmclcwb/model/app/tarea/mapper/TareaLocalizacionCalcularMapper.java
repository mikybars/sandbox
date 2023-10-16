package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionCalcularDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionCalcularDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionCalcular;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(TareaLocalizacionCalcularDecorator.class)
public abstract class TareaLocalizacionCalcularMapper {

  @Mapping(target = "idTarea", source = "tarea.id")
  public abstract TareaLocalizacionCalcularDto tareaLocalizacionCalcularToTareaLocalizacionCalcularDto(
      TareaLocalizacionCalcular src);

  public abstract List<TareaLocalizacionCalcularDto> tareaLocalizacionCalcularToTareaLocalizacionCalcularDto(
      List<TareaLocalizacionCalcular> src);

  @InheritInverseConfiguration
  public abstract TareaLocalizacionCalcular tareaLocalizacionCalcularDtoToTareaLocalizacionCalcular(
      TareaLocalizacionCalcularDto src);

  public abstract List<TareaLocalizacionCalcular> tareaLocalizacionCalcularDtoToLocalizacionCalcular(
      List<TareaLocalizacionCalcularDto> src);

  @Mapping(source = "src.idLugarTrabajoMtu", target = "cclIdCodOrigen")
  @Mapping(source = "src.idLugarTrabajo", target = "stdIdWorkLocat")
  @Mapping(source = "src.fechaInicio", target = "fechaInicio")
  @Mapping(source = "src.fechaFin", target = "fechaFin")
  @Mapping(source = "src.calcula", target = "calcula")
  @Mapping(source = "tareaDto.id", target = "tarea.id")
  @Mapping(target = "id", ignore = true)
  public abstract TareaLocalizacionCalcular genericTiendaResultItemDtoToTareaLocalizacionCalcular(
      GenericTiendaResultItemDto src, TareaDto tareaDto);

  public List<TareaLocalizacionCalcular> genericTiendaResultItemDtoToTareaLocalizacionCalcular(
      List<GenericTiendaResultItemDto> src, TareaDto tareaDto) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
