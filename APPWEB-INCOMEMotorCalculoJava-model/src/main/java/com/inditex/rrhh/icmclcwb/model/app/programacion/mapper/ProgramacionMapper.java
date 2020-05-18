package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.Programacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class ProgramacionMapper {

    @Mapping(target = "ambito", ignore = true)
    public abstract ProgramacionDto programacionToProgramacionDto(Programacion src);

    @Mapping(target = "tipoAmbito.nombre", ignore = true)
    public abstract Programacion programacionDtoToProgramacion(ProgramacionDto src);

    public abstract List<ProgramacionDto> programacionToProgramacionDto(List<Programacion> src);

    public abstract List<Programacion> programacionDtoToProgramacion(List<ProgramacionDto> src);

}

