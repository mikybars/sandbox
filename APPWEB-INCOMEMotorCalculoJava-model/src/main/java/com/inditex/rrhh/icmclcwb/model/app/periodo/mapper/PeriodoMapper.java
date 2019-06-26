package com.inditex.rrhh.icmclcwb.model.app.periodo.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;

@Mapper
public abstract class PeriodoMapper {

    @Mapping(target = "id", source = "src.idPeriodo")
    @Mapping(target = "fechaInicioPeriodo", source = "src.fechaInicio")
    @Mapping(target = "fechaFinPeriodo", source = "src.fechaFin")
    public abstract PeriodoDto periodoResultItemDtoToPeriodoDto(PeriodosResultItemDto src);

    @InheritInverseConfiguration
    public abstract PeriodosResultItemDto periodoDtoToPeriodoResultItemDto(PeriodoDto src);

    public abstract List<PeriodoDto> periodoResultItemDtoToPeriodoDto(List<PeriodosResultItemDto> src);

    public abstract List<PeriodosResultItemDto> periodoDtoToPeriodoResultItemDto(List<PeriodoDto> src);
}
