package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

/*
 * Copyright (c) 2022. Inditex
 */

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionFallidasDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccionFallidas;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TareaFaseAccionFallidasMapper {

  @Mapping(target = "idTareaFaseAccion", source = "pk.tareaFaseAccion.id")
  @Mapping(target = "idTipoFallidas", source = "tipoFallidas.id")
  public abstract TareaFaseAccionFallidasDto tareaFaseAccionFallidasToTareaFaseAccionFallidasDto(
      TareaFaseAccionFallidas src);

  public abstract List<TareaFaseAccionFallidasDto> tareaFaseAccionFallidasToTareaFaseAccionFallidasDto(
      List<TareaFaseAccionFallidas> src);

  @InheritInverseConfiguration
  public abstract TareaFaseAccionFallidas tareaFaseAccionFallidasDtoToTareaFaseAccionFallidas(
      TareaFaseAccionFallidasDto src);

  public abstract List<TareaFaseAccionFallidas> tareaFaseAccionFallidasDtoToTareaFaseAccionFallidas(
      List<TareaFaseAccionFallidasDto> src);

}
