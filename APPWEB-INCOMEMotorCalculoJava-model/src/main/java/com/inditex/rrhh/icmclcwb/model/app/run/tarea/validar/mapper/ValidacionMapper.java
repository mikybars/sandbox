/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.decorator.ValidacionMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author javierev
 */
@Mapper(imports = CollectionUtils.class)
@DecoratedWith(ValidacionMapperDecorator.class)
public interface ValidacionMapper {

    @Mapping(target = "result", expression = "java(CollectionUtils.isEmpty(condiciones))")
    @Mapping(target = "sincronizacion",
            expression = "java((properties.getSincronizacion() != null) && properties.getSincronizacion().isActivo() && (properties.getSincronizacion().getMaxEmpleados() >= condiciones.size()) )")
    @Mapping(target = "idTareaFaseAccion", source = "accion.id")
    @Mapping(target = "reaccionPeso", source = "accion.reaccionPeso")
    @Mapping(target = "cclIdOrigen", source = "ambito.cclIdOrigen")
    @Mapping(target = "idPersonaLocal", ignore = true)
    ValidacionDto idPersonaLocalCondicionesDtoTovalidacionDto(TareaAmbitoDto ambito, TareaFaseAccionDto accion,
            List<IdPersonaLocalCondicionesDto> condiciones, PrevalidarPropertiesDto properties);

    @Mapping(target = "result", expression = "java(CollectionUtils.isEmpty(personas))")
    @Mapping(target = "sincronizacion",
            expression = "java((properties.getSincronizacion() != null) && properties.getSincronizacion().isActivo() && (properties.getSincronizacion().getMaxEmpleados() >= personas.size()) )")
    @Mapping(target = "idTareaFaseAccion", source = "accion.id")
    @Mapping(target = "reaccionPeso", source = "accion.reaccionPeso")
    @Mapping(target = "cclIdOrigen", source = "ambito.cclIdOrigen")
    @Mapping(target = "idPersonaLocal", ignore = true)
    ValidacionDto idPersonaLocalDtoTovalidacionDto(TareaAmbitoDto ambito, TareaFaseAccionDto accion,
            List<IdPersonaLocalDto> personas, PrevalidarPropertiesDto properties);

    @Mapping(target = "result", expression = "java(CollectionUtils.isEmpty(incidencias))")
    @Mapping(target = "sincronizacion", constant = "false")
    @Mapping(target = "idTareaFaseAccion", source = "accion.id")
    @Mapping(target = "reaccionPeso", source = "accion.reaccionPeso")
    @Mapping(target = "cclIdOrigen", source = "ambito.cclIdOrigen")
    @Mapping(target = "idPersonaLocal", ignore = true)
    ValidacionDto idPersonaLocalFechaIncidenciaDtoToValidacionDto(TareaAmbitoDto ambito, TareaFaseAccionDto accion,
            List<IdPersonaLocalFechaIncidenciaDto> incidencias);

}
