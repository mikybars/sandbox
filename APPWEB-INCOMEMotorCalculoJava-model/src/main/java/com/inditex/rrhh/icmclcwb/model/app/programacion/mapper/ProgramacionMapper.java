package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.Programacion;

import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public abstract class ProgramacionMapper {

    public abstract ProgramacionDto programacionToProgramacionDto(Programacion src);

    public abstract Programacion programacionDtoToProgramacion(ProgramacionDto src);

    public abstract List<ProgramacionDto> programacionToProgramacionDto(List<Programacion> src);

    public abstract List<Programacion> programacionDtoToProgramacion(List<ProgramacionDto> src);

}

