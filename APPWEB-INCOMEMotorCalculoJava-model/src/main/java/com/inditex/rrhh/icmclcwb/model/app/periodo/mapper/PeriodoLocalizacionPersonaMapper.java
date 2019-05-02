package com.inditex.rrhh.icmclcwb.model.app.periodo.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.PeriodoLocalizacionPersonaDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.entity.PeriodoLocalizacionPersona;

@Mapper
public abstract class PeriodoLocalizacionPersonaMapper {

    public abstract PeriodoLocalizacionPersonaDto periodoLocalizacionPersonaToPeriodoLocalizacionPersonaDto(PeriodoLocalizacionPersona src);

    @InheritInverseConfiguration
    public abstract PeriodoLocalizacionPersona periodoLocalizacionPersonaDtoToPeriodoLocalizacionPersona(PeriodoLocalizacionPersonaDto src);

    public abstract List<PeriodoLocalizacionPersonaDto> periodoLocalizacionPersonaToPeriodoLocalizacionPersonaDto(List<PeriodoLocalizacionPersona> src);

    public abstract List<PeriodoLocalizacionPersona> periodoLocalizacionPersonaDtoToPeriodoLocalizacionPersona(List<PeriodoLocalizacionPersonaDto> src);
}
