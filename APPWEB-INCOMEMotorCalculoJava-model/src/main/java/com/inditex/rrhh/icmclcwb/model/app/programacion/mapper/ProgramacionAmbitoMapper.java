package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.decorator.ProgramacionAmbitoMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbito;
import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(value = ProgramacionAmbitoMapperDecorator.class)
public abstract class ProgramacionAmbitoMapper {

    @Mapping(target = "origen", ignore = true)
    @Mapping(target = "empresa", ignore = true)
    @Mapping(target = "persona", ignore = true)
    @Mapping(target = "localizacion", ignore = true)
    @Mapping(target = "idProgramacion", source = "programacion.id")
    public abstract ProgramacionAmbitoDto programacionAmbitoToProgramacionAmbitoDto(ProgramacionAmbito src);

    @InheritInverseConfiguration
    public abstract ProgramacionAmbito programacionAmbitoDtoToProgramacionAmbito(ProgramacionAmbitoDto src);

    public abstract List<ProgramacionAmbitoDto> programacionAmbitoToProgramacionAmbitoDto(List<ProgramacionAmbito> src);

    public abstract List<ProgramacionAmbito> programacionAmbitoDtoToProgramacionAmbito(List<ProgramacionAmbitoDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "programacion.id", source = "srcProgramacion.id")
    public abstract ProgramacionAmbito mergeProgramacionAmbitoDtoAndProgramacionDtoToProgramacionAmbito(
            ProgramacionAmbitoDto srcProgramacionAmbito, ProgramacionDto srcProgramacion);

    public List<ProgramacionAmbito> mergeProgramacionAmbitoDtoAndProgramacionDtoToProgramacionAmbito(
            final List<ProgramacionAmbitoDto> srcProgramacionAmbito, final ProgramacionDto srcProgramacion) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

}
