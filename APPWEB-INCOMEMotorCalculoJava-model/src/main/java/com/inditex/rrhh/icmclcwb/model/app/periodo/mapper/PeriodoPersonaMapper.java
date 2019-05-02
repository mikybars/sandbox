package com.inditex.rrhh.icmclcwb.model.app.periodo.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.PeriodoPersonaDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.entity.PeriodoPersona;

@Mapper
public abstract class PeriodoPersonaMapper {

    public abstract PeriodoPersonaDto periodoPersonaToPeriodoPersonaDto(PeriodoPersona src);

    @InheritInverseConfiguration
    public abstract PeriodoPersona periodoPersonaDtoToPeriodoPersona(PeriodoPersonaDto src);

    public abstract List<PeriodoPersonaDto> periodoPersonaToPeriodoPersonaDto(List<PeriodoPersona> src);

    public abstract List<PeriodoPersona> periodoPersonaDtoToPeriodoPersona(List<PeriodoPersonaDto> src);
}
