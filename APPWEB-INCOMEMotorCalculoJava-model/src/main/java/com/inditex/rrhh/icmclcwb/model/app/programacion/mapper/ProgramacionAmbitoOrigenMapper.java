package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.decorator.ProgramacionAmbitoOrigenMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoOrigen;

@Mapper
@DecoratedWith(value = ProgramacionAmbitoOrigenMapperDecorator.class)
public abstract class ProgramacionAmbitoOrigenMapper {

    @Mapping(target = "idProgramacionAmbito", source = "programacionAmbito.id")
    public abstract ProgramacionAmbitoOrigenDto programacionAmbitoOrigenToProgramacionAmbitoOrigenDto(ProgramacionAmbitoOrigen src);

    @InheritInverseConfiguration
    public abstract ProgramacionAmbitoOrigen programacionAmbitoOrigenDtoToProgramacionAmbitoOrigen(ProgramacionAmbitoOrigenDto src);

    public abstract List<ProgramacionAmbitoOrigenDto> programacionAmbitoOrigenToProgramacionAmbitoOrigenDto(List<ProgramacionAmbitoOrigen> src);

    public abstract List<ProgramacionAmbitoOrigen> programacionAmbitoOrigenDtoToProgramacionAmbitoOrigen(List<ProgramacionAmbitoOrigenDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "programacionAmbito.id", source = "srcProgramacionAmbito.id")
    public abstract ProgramacionAmbitoOrigen mergeProgramacionAmbitoOrigenDtoAndProgramacionDtoToProgramacionAmbitoOrigen(
            ProgramacionAmbitoOrigenDto srcProgramacionAmbitoOrigen, ProgramacionAmbitoDto srcProgramacionAmbito);

    public List<ProgramacionAmbitoOrigen> mergeProgramacionAmbitoOrigenDtoAndProgramacionDtoToProgramacionAmbitoOrigen(
            List<ProgramacionAmbitoOrigenDto> srcProgramacionAmbitoOrigen, ProgramacionAmbitoDto srcProgramacionAmbito) {
        throw new UnsupportedOperationException("Not implemented");
    }
    
}
