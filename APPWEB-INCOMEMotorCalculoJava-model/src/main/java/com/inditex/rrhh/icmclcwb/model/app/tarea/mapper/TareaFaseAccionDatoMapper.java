package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDatoDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccionDato;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TareaFaseAccionDatoMapper {

  @Mapping(target = "idTareaFaseAccion", source = "pk.tareaFaseAccion.id")
  @Mapping(target = "idTipoDato", source = "tipoDato.id")
  @Mapping(target = "dato", source = "pk.dato")
  public abstract TareaFaseAccionDatoDto tareaFaseAccionDatoToTareaFaseAccionDatoDto(
      TareaFaseAccionDato src);

  public abstract List<TareaFaseAccionDatoDto> tareaFaseAccionDatoToTareaFaseAccionDatoDto(
      List<TareaFaseAccionDato> src);

  @InheritInverseConfiguration
  public abstract TareaFaseAccionDato tareaFaseAccionDatoDtoToTareaFaseAccionDato(
      TareaFaseAccionDatoDto src);

  public abstract List<TareaFaseAccionDato> tareaFaseAccionDatoDtoToTareaFaseAccionDato(
      List<TareaFaseAccionDatoDto> src);

}
