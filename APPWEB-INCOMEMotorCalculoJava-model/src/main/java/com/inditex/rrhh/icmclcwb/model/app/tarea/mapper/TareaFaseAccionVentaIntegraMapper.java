package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionVentaIntegraDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccionVentaIntegra;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TareaFaseAccionVentaIntegraMapper {

  @Mapping(target = "idTareaFaseAccion", source = "pk.tareaFaseAccion.id")
  @Mapping(target = "idTipoDato", source = "pk.tipoDato.id")
  @Mapping(target = "tienda", source = "pk.tienda")
  @Mapping(target = "fechaDesintegridad", source = "pk.fechaDesintegridad")
  public abstract TareaFaseAccionVentaIntegraDto tareaFaseAccionVentaIntegraToTareaFaseAccionVentaIntegraDto(
      TareaFaseAccionVentaIntegra src);

  public abstract List<TareaFaseAccionVentaIntegraDto> tareaFaseAccionVentaIntegraToTareaFaseAccionVentaIntegraDto(
      List<TareaFaseAccionVentaIntegra> src);

  @InheritInverseConfiguration
  public abstract TareaFaseAccionVentaIntegra tareaFaseAccionVentaIntegraDtoToTareaFaseAccionVentaIntegra(
      TareaFaseAccionVentaIntegraDto src);

  public abstract List<TareaFaseAccionVentaIntegra> tareaFaseAccionVentaIntegraDtoToTareaFaseAccionVentaIntegra(
      List<TareaFaseAccionVentaIntegraDto> src);

}
