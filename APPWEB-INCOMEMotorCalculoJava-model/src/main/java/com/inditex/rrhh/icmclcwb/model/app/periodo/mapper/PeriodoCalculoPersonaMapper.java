package com.inditex.rrhh.icmclcwb.model.app.periodo.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.PeriodoCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.entity.PeriodoCalculoPersona;

@Mapper
public abstract class PeriodoCalculoPersonaMapper {

    public abstract PeriodoCalculoPersonaDto periodoCalculoPersonaToPeriodoCalculoPersonaDto(PeriodoCalculoPersona src);

    @InheritInverseConfiguration
    public abstract PeriodoCalculoPersona periodoCalculoPersonaDtoToPeriodoCalculoPersona(PeriodoCalculoPersonaDto src);

    public abstract List<PeriodoCalculoPersonaDto> periodoCalculoPersonaToPeriodoCalculoPersonaDto(List<PeriodoCalculoPersona> src);

    public abstract List<PeriodoCalculoPersona> periodoCalculoPersonaDtoToPeriodoCalculoPersona(List<PeriodoCalculoPersonaDto> src);
}
