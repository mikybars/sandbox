package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoItemDto;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.decorator.ValidacionMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = {CollectionUtils.class, ArrayList.class})
@DecoratedWith(ValidacionMapperDecorator.class)
public interface ValidacionMapper {

  @Mapping(target = "result", expression = "java(CollectionUtils.isEmpty(personas))")
  @Mapping(target = "sincronizacion",
      expression = "java((properties.getSincronizacion() != null) && properties.getSincronizacion().isActivo() && "
          + "(properties.getSincronizacion().getMaxEmpleados() >= personas.size()) )")
  @Mapping(target = "idTareaFaseAccion", source = "accion.id")
  @Mapping(target = "reaccionPeso", source = "accion.reaccionPeso")
  @Mapping(target = "cclIdOrigen", source = "ambito.cclIdOrigen")
  @Mapping(target = "stdIdLegEnt", source = "tareaDto.stdIdLegEnt")
  @Mapping(target = "idPersonaLocal", ignore = true)
  @Mapping(target = "idMotivosDesplazamiento", expression = "java(new ArrayList<>())")
  ValidacionDto idPersonaLocalDtoTovalidacionDto(TareaAmbitoDto ambito, TareaFaseAccionDto accion,
      List<IdPersonaLocalDto> personas, PrevalidarPropertiesDto properties, TareaDto tareaDto);

  @Mapping(target = "result", expression = "java(CollectionUtils.isEmpty(incidencias))")
  @Mapping(target = "sincronizacion", constant = "false")
  @Mapping(target = "idTareaFaseAccion", source = "accion.id")
  @Mapping(target = "reaccionPeso", source = "accion.reaccionPeso")
  @Mapping(target = "cclIdOrigen", source = "ambito.cclIdOrigen")
  @Mapping(target = "idPersonaLocal", ignore = true)
  @Mapping(target = "idMotivosDesplazamiento", expression = "java(new ArrayList<>())")
  ValidacionDto idPersonaLocalFechaIncidenciaDtoToValidacionDto(TareaAmbitoDto ambito, TareaFaseAccionDto accion,
      List<IdPersonaLocalFechaIncidenciaDto> incidencias, PrevalidarPropertiesDto properties);

  @Mapping(target = "idMotivoDesplazamiento", source = "idMotivo")
  IdMotivoDesplazamientoDto motivosDesplazamientoItemDtoToIdMotivoDesplazamientoDto(MotivosDesplazamientoItemDto src);

  List<IdMotivoDesplazamientoDto> motivosDesplazamientoItemDtoToIdMotivoDesplazamientoDto(
      List<MotivosDesplazamientoItemDto> src);

  @Mapping(target = "result", expression = "java(CollectionUtils.isEmpty(motivos))")
  @Mapping(target = "sincronizacion", constant = "false")
  @Mapping(target = "idTareaFaseAccion", source = "accion.id")
  @Mapping(target = "reaccionPeso", source = "accion.reaccionPeso")
  @Mapping(target = "cclIdOrigen", source = "ambito.cclIdOrigen")
  @Mapping(target = "idPersonaLocal", expression = "java(new ArrayList<>())")
  @Mapping(target = "idMotivosDesplazamiento", ignore = true)
  ValidacionDto idMotivoDesplazamientoDtoToValidacionDto(TareaAmbitoDto ambito, TareaFaseAccionDto accion,
      List<IdMotivoDesplazamientoDto> motivos);

  @Mapping(target = "result", source = "result")
  @Mapping(target = "sincronizacion", constant = "false")
  @Mapping(target = "idTareaFaseAccion", source = "accion.id")
  @Mapping(target = "reaccionPeso", source = "accion.reaccionPeso")
  @Mapping(target = "cclIdOrigen", source = "ambito.cclIdOrigen")
  @Mapping(target = "idPersonaLocal", expression = "java(new ArrayList<>())")
  @Mapping(target = "idMotivosDesplazamiento", expression = "java(new ArrayList<>())")
  ValidacionDto booleanToValidacionDto(TareaAmbitoDto ambito, TareaFaseAccionDto accion, boolean result);

  @Mapping(target = "result", source = "result")
  @Mapping(target = "sincronizacion", constant = "false")
  @Mapping(target = "idTareaFaseAccion", source = "accion.id")
  @Mapping(target = "reaccionPeso", source = "accion.reaccionPeso")
  @Mapping(target = "cclIdOrigen", source = "ambito.cclIdOrigen")
  @Mapping(target = "idPersonaLocal", expression = "java(new ArrayList<>())")
  @Mapping(target = "idMotivosDesplazamiento", expression = "java(new ArrayList<>())")
  @Mapping(target = "comis", source = "comis")
  @Mapping(target = "ptr", source = "ptr")
  ValidacionDto booleanToValidacionDto(TareaAmbitoDto ambito, TareaFaseAccionDto accion, boolean result, PresenciaOrigenDto comis,
      PresenciaOrigenDto ptr);

}
