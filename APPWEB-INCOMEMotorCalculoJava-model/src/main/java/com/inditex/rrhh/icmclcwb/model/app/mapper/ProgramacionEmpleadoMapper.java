package com.inditex.rrhh.icmclcwb.model.app.mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionEmpleadoDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.decorator.ProgramacionEmpleadoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.entity.ProgramacionEmpleado;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper
@DecoratedWith(ProgramacionEmpleadoDecorator.class)
public abstract class ProgramacionEmpleadoMapper {

    @Mapping(source = "programacion.id", target = "programacion.id")
    public abstract ProgramacionEmpleadoDto programacionEmpleadoToProgramacionEmpleadoDto(ProgramacionEmpleado src);

    @Mapping(source = "programacion.id", target = "programacion.id")
    public abstract ProgramacionEmpleado programacionEmpleadoDtoToProgramacionEmpleado(ProgramacionEmpleadoDto src);

    public abstract List<ProgramacionEmpleadoDto> programacionEmpleadoToProgramacionEmpleadoDto(
            List<ProgramacionEmpleado> src);

    public abstract List<ProgramacionEmpleado> programacionEmpleadoDtoToProgramacionEmpleado(
            List<ProgramacionEmpleadoDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "programacion.id", source = "srcProgramacionDto.id")
    public abstract ProgramacionEmpleado mergeProgramacionEmpleadoDtoAndProgramacionDtoToProgramacionEmpleado(
            ProgramacionEmpleadoDto srcProgramacionEmpleadoDto, ProgramacionDto srcProgramacionDto);

    public List<ProgramacionEmpleado> mergeProgramacionEmpleadoDtoAndProgramacionDtoToProgramacionEmpleado(
            List<ProgramacionEmpleadoDto> srcProgramacionEmpleadoDto, ProgramacionDto srcProgramacionDto) {
        throw new UnsupportedOperationException("Not implemented");
    }

}