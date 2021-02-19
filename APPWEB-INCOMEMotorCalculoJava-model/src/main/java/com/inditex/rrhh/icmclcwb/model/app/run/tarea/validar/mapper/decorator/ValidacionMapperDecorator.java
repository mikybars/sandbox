/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.decorator;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;

/**
 * @author javierev
 */
public abstract class ValidacionMapperDecorator implements ValidacionMapper {

    @Autowired
    private ValidacionMapper delegate;

    @Override
    public ValidacionDto idPersonaLocalCondicionesDtoTovalidacionDto(
            final TareaAmbitoDto ambito,
            final TareaFaseAccionDto accion,
            final List<IdPersonaLocalCondicionesDto> condiciones) {
        final ValidacionDto result = this.delegate.idPersonaLocalCondicionesDtoTovalidacionDto(ambito, accion,
                condiciones);
        if (CollectionUtils.isNotEmpty(condiciones)) {
            result.setIdPersonaLocal(condiciones.stream().map(x -> x.getIdPersonaLocal()).collect(Collectors.toList()));
        }
        return result;
    }

    @Override
    public ValidacionDto idPersonaLocalCarenciaDtoTovalidacionDto(
            final TareaAmbitoDto ambito, final TareaFaseAccionDto accion,
            final List<IdPersonaLocalCarenciaDto> carencias) {
        final ValidacionDto result = this.delegate.idPersonaLocalCarenciaDtoTovalidacionDto(ambito, accion, carencias);
        if (CollectionUtils.isNotEmpty(carencias)) {
            result.setIdPersonaLocal(carencias.stream().map(x -> x.getIdPersonaLocal()).collect(Collectors.toList()));
        }
        return result;
    }

}
