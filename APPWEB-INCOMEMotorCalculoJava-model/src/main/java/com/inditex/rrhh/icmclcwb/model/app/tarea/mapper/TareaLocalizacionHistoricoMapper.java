package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionHistoricoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionHistorico;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(TareaLocalizacionHistoricoDecorator.class)
public abstract class TareaLocalizacionHistoricoMapper {

  @Mapping(target = "idTarea", source = "tarea.id")
  public abstract TareaLocalizacionHistoricoDto tareaLocalizacionHistoricoToTareaLocalizacionHistoricoDto(
      TareaLocalizacionHistorico src);

  public abstract List<TareaLocalizacionHistoricoDto> tareaLocalizacionHistoricoToTareaLocalizacionHistoricoDto(
      List<TareaLocalizacionHistorico> src);

  @InheritInverseConfiguration
  public abstract TareaLocalizacionHistorico tareaLocalizacionHistoricoDtoToTareaLocalizacionHistorico(
      TareaLocalizacionHistoricoDto src);

  public abstract List<TareaLocalizacionHistorico> tareaLocalizacionHistoricoDtoToTareaLocalizacionHistorico(
      List<TareaLocalizacionHistoricoDto> src);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "stdIdCountry", source = "src.idOrigen")
  @Mapping(target = "stdIdSubGeoDiv", source = "src.idProvincia")
  @Mapping(target = "cclIdOrigen", source = "src.idOrigen")
  @Mapping(target = "stdIdLegEnt", source = "src.idEmpresa")
  @Mapping(target = "cclIdCadena", source = "src.idCadena")
  @Mapping(target = "cclIdCodOrigen", source = "src.idLugarTrabajoMtu")
  @Mapping(target = "stdIdWorkLocat", source = "src.idLugarTrabajo")
  @Mapping(target = "fechaInicio", source = "src.fechaInicio")
  @Mapping(target = "fechaFin", source = "src.fechaFin")
  @Mapping(target = "idTarea", source = "srcTarea.id")
  public abstract TareaLocalizacionHistoricoDto genericLocalizacionResultItemDtoToTareaLocalizacionHistoricoDto(
      GenericTiendaResultItemDto src, TareaDto srcTarea);

  public List<TareaLocalizacionHistoricoDto> genericLocalizacionResultItemDtoToTareaLocalizacionHistoricoDto(
      final List<GenericTiendaResultItemDto> src, final TareaDto srcTarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
