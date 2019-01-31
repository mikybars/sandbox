package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionEmpleadoDto;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.decorator.ProgramacionEmpleadoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.entity.ProgramacionEmpleado;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper
@DecoratedWith(ProgramacionEmpleadoDecorator.class)
public abstract class ProgramacionEmpleadoMapper {

    @Mapping(target = "idProgramacion", source = "programacion.id")
    public abstract ProgramacionEmpleadoDto programacionEmpleadoToProgramacionEmpleadoDto(ProgramacionEmpleado src);

    @InheritInverseConfiguration
    public abstract ProgramacionEmpleado programacionEmpleadoDtoToProgramacionEmpleado(ProgramacionEmpleadoDto src);

    public abstract List<ProgramacionEmpleadoDto> programacionEmpleadoToProgramacionEmpleadoDto(
            List<ProgramacionEmpleado> src);

    public abstract List<ProgramacionEmpleado> programacionEmpleadoDtoToProgramacionEmpleado(
            List<ProgramacionEmpleadoDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "programacion.id", source = "srcProgramacion.id")
    public abstract ProgramacionEmpleado mergeProgramacionEmpleadoDtoAndProgramacionDtoToProgramacionEmpleado(
            ProgramacionEmpleadoDto srcProgramacionEmpleado, ProgramacionDto srcProgramacion);

    public List<ProgramacionEmpleado> mergeProgramacionEmpleadoDtoAndProgramacionDtoToProgramacionEmpleado(
            List<ProgramacionEmpleadoDto> srcProgramacionEmpleadoDto, ProgramacionDto srcProgramacionDto) {
        throw new UnsupportedOperationException("Not implemented");
    }

}
