package com.inditex.rrhh.icmclcwb.model.app.periodo.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.PeriodoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.entity.PeriodoLocalizacion;

@Mapper
public abstract class PeriodoLocalizacionMapper {

    public abstract PeriodoLocalizacionDto periodoLocalizacionToPeriodoLocalizacionDto(PeriodoLocalizacion src);

    @InheritInverseConfiguration
    public abstract PeriodoLocalizacion periodoLocalizacionDtoToPeriodoLocalizacion(PeriodoLocalizacionDto src);

    public abstract List<PeriodoLocalizacionDto> periodoLocalizacionToPeriodoLocalizacionDto(List<PeriodoLocalizacion> src);

    public abstract List<PeriodoLocalizacion> periodoLocalizacionDtoToPeriodoLocalizacion(List<PeriodoLocalizacionDto> src);
}
