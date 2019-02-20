package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.decorator.ProgramacionAmbitoPersonaMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoPersona;

@Mapper
@DecoratedWith(value = ProgramacionAmbitoPersonaMapperDecorator.class)
public abstract class ProgramacionAmbitoPersonaMapper {

    @Mapping(target = "idProgramacionAmbito", source = "programacionAmbito.id")
    public abstract ProgramacionAmbitoPersonaDto programacionAmbitoPersonaToProgramacionAmbitoPersonaDto(ProgramacionAmbitoPersona src);

    @InheritInverseConfiguration
    public abstract ProgramacionAmbitoPersona programacionAmbitoPersonaDtoToProgramacionAmbitoPersona(ProgramacionAmbitoPersonaDto src);

    public abstract List<ProgramacionAmbitoPersonaDto> programacionAmbitoPersonaToProgramacionAmbitoPersonaDto(List<ProgramacionAmbitoPersona> src);

    public abstract List<ProgramacionAmbitoPersona> programacionAmbitoPersonaDtoToProgramacionAmbitoPersona(List<ProgramacionAmbitoPersonaDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "programacionAmbito.id", source = "srcProgramacionAmbito.id")
    public abstract ProgramacionAmbitoPersona mergeProgramacionAmbitoPersonaDtoAndProgramacionDtoToProgramacionAmbitoPersona(
            ProgramacionAmbitoPersonaDto srcProgramacionAmbitoPersona, ProgramacionAmbitoDto srcProgramacionAmbito);

    public List<ProgramacionAmbitoPersona> mergeProgramacionAmbitoPersonaDtoAndProgramacionDtoToProgramacionAmbitoPersona(
            List<ProgramacionAmbitoPersonaDto> srcProgramacionAmbitoPersona, ProgramacionAmbitoDto srcProgramacionAmbito) {
        throw new UnsupportedOperationException("Not implemented");
    }
    
}
