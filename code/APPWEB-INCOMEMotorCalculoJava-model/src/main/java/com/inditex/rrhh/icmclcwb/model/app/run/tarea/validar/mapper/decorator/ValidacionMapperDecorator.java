package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.decorator;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class ValidacionMapperDecorator implements ValidacionMapper {

  @Autowired
  private ValidacionMapper delegate;

  @Override
  public ValidacionDto idPersonaLocalDtoTovalidacionDto(final TareaAmbitoDto ambito,
      final TareaFaseAccionDto accion, final List<IdPersonaLocalDto> personas,
      final PrevalidarPropertiesDto properties, final TareaDto tareaDto) {
    final ValidacionDto result = this.delegate.idPersonaLocalDtoTovalidacionDto(ambito, accion,
        personas, properties, tareaDto);
    result.setIdPersonaLocal(new ArrayList<>());
    if (CollectionUtils.isNotEmpty(personas)) {
      result.setIdPersonaLocal(personas.stream()
          .map(IdPersonaLocalDto::getIdPersonaLocal)
          .collect(Collectors.toList()));
    }
    return result;
  }

  @Override
  public ValidacionDto idLocalizacionLocalDtoTovalidacionDto(final TareaAmbitoDto ambito,
      final TareaFaseAccionDto accion, final List<IdLocalizacionLocalDto> tiendas,
      final PrevalidarPropertiesDto properties, final TareaDto tareaDto) {
    final ValidacionDto result = this.delegate.idLocalizacionLocalDtoTovalidacionDto(ambito, accion,
        tiendas, properties, tareaDto);
    result.setIdPersonaLocal(new ArrayList<>());
    result.setIdLocalizacionLocal(new ArrayList<>());
    if (CollectionUtils.isNotEmpty(tiendas)) {
      result.setIdLocalizacionLocal(tiendas.stream()
          .map(IdLocalizacionLocalDto::getId)
          .toList());
    }
    return result;
  }

  @Override
  public ValidacionDto idPersonaLocalFechaIncidenciaDtoToValidacionDto(
      final TareaAmbitoDto ambito, final TareaFaseAccionDto accion,
      final List<IdPersonaLocalFechaIncidenciaDto> incidencias, final PrevalidarPropertiesDto properties) {
    final ValidacionDto result = this.delegate.idPersonaLocalFechaIncidenciaDtoToValidacionDto(ambito, accion,
        incidencias, properties);
    result.setIdPersonaLocal(new ArrayList<>());
    if (CollectionUtils.isNotEmpty(incidencias)) {
      result.setIdPersonaLocal(incidencias.stream()
          .map(IdPersonaLocalFechaIncidenciaDto::getIdPersonaLocal)
          .distinct()
          .collect(Collectors.toList()));
    }
    result.setSincronizacion(properties.getSincronizacion().isActivo()
        && (result.getIdPersonaLocal().size() >= properties.getSincronizacion().getMaxEmpleados()));
    return result;
  }

  @Override
  public ValidacionDto idMotivoDesplazamientoDtoToValidacionDto(
      final TareaAmbitoDto ambito, final TareaFaseAccionDto accion,
      final List<IdMotivoDesplazamientoDto> motivos) {
    final ValidacionDto result = this.delegate.idMotivoDesplazamientoDtoToValidacionDto(ambito, accion, motivos);
    result.setIdMotivosDesplazamiento(new ArrayList<>());
    if (CollectionUtils.isNotEmpty(motivos)) {
      result.setIdMotivosDesplazamiento(motivos.stream()
          .map(IdMotivoDesplazamientoDto::getIdMotivoDesplazamiento)
          .collect(
              Collectors.toList()));
    }
    return result;
  }

}
