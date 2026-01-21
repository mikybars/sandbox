package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccion;

import org.mapstruct.Builder;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(builder = @Builder(disableBuilder = true))
public abstract class TareaFaseAccionMapper {

  @Mapping(target = "idAccion", source = "accion.id")
  @Mapping(target = "idTareaFase", source = "tareaFase.id")
  @Mapping(target = "idPuntoEjecucion", source = "puntoEjecucion.id")
  @Mapping(target = "idEstadoTareaFaseAccion", source = "estadoTareaFaseAccion.id")
  public abstract TareaFaseAccionDto tareaFaseAccionToTareaFaseAccionDto(
      TareaFaseAccion src);

  public abstract List<TareaFaseAccionDto> tareaFaseAccionToTareaFaseAccionDto(
      List<TareaFaseAccion> src);

  @InheritInverseConfiguration
  public abstract TareaFaseAccion tareaFaseAccionDtoToTareaFaseAccion(
      TareaFaseAccionDto src);

  public abstract List<TareaFaseAccion> tareaFaseAccionDtoToTareaFaseAccion(
      List<TareaFaseAccionDto> src);

}
