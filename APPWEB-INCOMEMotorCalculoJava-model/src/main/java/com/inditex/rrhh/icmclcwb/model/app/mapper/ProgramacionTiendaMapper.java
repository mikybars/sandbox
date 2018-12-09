package com.inditex.rrhh.icmclcwb.model.app.mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionTiendaDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.decorator.ProgramacionTiendaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.entity.ProgramacionTienda;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper
@DecoratedWith(ProgramacionTiendaDecorator.class)
public abstract class ProgramacionTiendaMapper {

    @Mapping(target = "idProgramacion", source = "programacion.id")
    public abstract ProgramacionTiendaDto programacionTiendaToProgramacionTiendaDto(ProgramacionTienda src);

    @InheritInverseConfiguration
    public abstract ProgramacionTienda programacionTiendaDtoToProgramacionTienda(ProgramacionTiendaDto src);

    public abstract List<ProgramacionTiendaDto> programacionTiendaToProgramacionTiendaDto(List<ProgramacionTienda> src);

    public abstract List<ProgramacionTienda> programacionTiendaDtoToProgramacionTienda(List<ProgramacionTiendaDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "programacion.id", source = "srcProgramacion.id")
    public abstract ProgramacionTienda mergeProgramacionTiendaDtoAndProgramacionDtoToProgramacionTienda(
            ProgramacionTiendaDto srcProgramacionTiendaDto, ProgramacionDto srcProgramacion);

    public List<ProgramacionTienda> mergeProgramacionTiendaDtoAndProgramacionDtoToProgramacionTienda(
            List<ProgramacionTiendaDto> srcProgramacionTiendaDto, ProgramacionDto srcProgramacionDto) {
        throw new UnsupportedOperationException("Not implemented");
    }

}