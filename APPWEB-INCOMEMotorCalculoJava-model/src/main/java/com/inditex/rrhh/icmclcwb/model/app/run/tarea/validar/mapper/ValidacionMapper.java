/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
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
    @Mapping(target = "idTareaFaseAccion", source = "accion.id")
    @Mapping(target = "reaccionPeso", source = "accion.reaccionPeso")
    @Mapping(target = "cclIdOrigen", source = "ambito.cclIdOrigen")
    @Mapping(target = "idPersonaLocal", ignore = true)
    ValidacionDto idPersonaLocalCondicionesDtoTovalidacionDto(TareaAmbitoDto ambito, TareaFaseAccionDto accion,
            List<IdPersonaLocalCondicionesDto> condiciones);

    @Mapping(target = "result", expression = "java(CollectionUtils.isEmpty(personas))")
    @Mapping(target = "idTareaFaseAccion", source = "accion.id")
    @Mapping(target = "reaccionPeso", source = "accion.reaccionPeso")
    @Mapping(target = "cclIdOrigen", source = "ambito.cclIdOrigen")
    @Mapping(target = "idPersonaLocal", ignore = true)
    ValidacionDto idPersonaLocalDtoTovalidacionDto(TareaAmbitoDto ambito, TareaFaseAccionDto accion,
            List<IdPersonaLocalDto> personas);

    @Mapping(target = "result", expression = "java(CollectionUtils.isEmpty(carencias))")
    @Mapping(target = "idTareaFaseAccion", source = "accion.id")
    @Mapping(target = "reaccionPeso", source = "accion.reaccionPeso")
    @Mapping(target = "cclIdOrigen", source = "ambito.cclIdOrigen")
    @Mapping(target = "idPersonaLocal", ignore = true)
    ValidacionDto idPersonaLocalCarenciaDtoTovalidacionDto(TareaAmbitoDto ambito, TareaFaseAccionDto accion,
            List<IdPersonaLocalCarenciaDto> carencias);

    @Mapping(target = "result", expression = "java(CollectionUtils.isEmpty(incidencias))")
    @Mapping(target = "idTareaFaseAccion", source = "accion.id")
    @Mapping(target = "reaccionPeso", source = "accion.reaccionPeso")
    @Mapping(target = "cclIdOrigen", source = "ambito.cclIdOrigen")
    @Mapping(target = "idPersonaLocal", ignore = true)
    ValidacionDto idPersonaLocalFechaIncidenciaDtoToValidacionDto(TareaAmbitoDto ambito, TareaFaseAccionDto accion,
            List<IdPersonaLocalFechaIncidenciaDto> incidencias);

}
