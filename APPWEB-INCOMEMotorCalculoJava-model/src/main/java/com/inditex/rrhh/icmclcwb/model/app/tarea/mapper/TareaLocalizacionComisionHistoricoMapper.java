package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionComisionHistoricoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionComisionHistorico;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(value = TareaLocalizacionComisionHistoricoDecorator.class)
public abstract class TareaLocalizacionComisionHistoricoMapper {

  @Mapping(target = "idTarea", source = "tarea.id")
  public abstract TareaLocalizacionComisionHistoricoDto tareaLocalizacionComisionHistoricoToTareaLocalizacionComisionHistoricoDto(
      TareaLocalizacionComisionHistorico src);

  public abstract List<TareaLocalizacionComisionHistoricoDto> tareaLocalizacionComisionHistoricoToTareaLocalizacionComisionHistoricoDto(
      List<TareaLocalizacionComisionHistorico> src);

  @InheritInverseConfiguration
  public abstract TareaLocalizacionComisionHistorico tareaLocalizacionComisionHistoricoDtoToTareaLocalizacionComisionHistorico(
      TareaLocalizacionComisionHistoricoDto src);

  @InheritInverseConfiguration
  public abstract List<TareaLocalizacionComisionHistorico> tareaLocalizacionComisionHistoricoDtoToTareaLocalizacionComisionHistorico(
      List<TareaLocalizacionComisionHistoricoDto> src);

  @Mapping(target = "cclIdCodOrigen", source = "src.idLugarTrabajoMtu")
  @Mapping(target = "stdIdWorkLocat", source = "src.idLugarTrabajo")
  @Mapping(target = "fechaInicio", source = "src.fechaInicio")
  @Mapping(target = "fechaFin", source = "src.fechaFin")
  @Mapping(target = "comisionable", source = "src.esComisionable")
  @Mapping(target = "idTarea", source = "srcTarea.id")
  public abstract TareaLocalizacionComisionHistoricoDto genericLocalizacionResultItemDtoToTareaLocalizacionComisionHistoricoDto(
      GenericTiendaResultItemDto src, TareaDto srcTarea);

  public List<TareaLocalizacionComisionHistoricoDto> genericLocalizacionResultItemDtoToTareaLocalizacionComisionHistoricoDto(
      List<GenericTiendaResultItemDto> src, TareaDto srcTarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
