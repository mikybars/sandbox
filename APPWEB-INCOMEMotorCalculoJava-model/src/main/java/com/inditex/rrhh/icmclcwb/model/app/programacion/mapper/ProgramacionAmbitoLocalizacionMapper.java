package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.decorator.ProgramacionAmbitoLocalizacionMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoLocalizacion;

@Mapper
@DecoratedWith(value = ProgramacionAmbitoLocalizacionMapperDecorator.class)
public abstract class ProgramacionAmbitoLocalizacionMapper {

    @Mapping(target = "idProgramacionAmbito", source = "programacionAmbito.id")
    public abstract ProgramacionAmbitoLocalizacionDto programacionAmbitoLocalizacionToProgramacionAmbitoLocalizacionDto(ProgramacionAmbitoLocalizacion src);

    @InheritInverseConfiguration
    public abstract ProgramacionAmbitoLocalizacion programacionAmbitoLocalizacionDtoToProgramacionAmbitoLocalizacion(ProgramacionAmbitoLocalizacionDto src);

    public abstract List<ProgramacionAmbitoLocalizacionDto> programacionAmbitoLocalizacionToProgramacionAmbitoLocalizacionDto(List<ProgramacionAmbitoLocalizacion> src);

    public abstract List<ProgramacionAmbitoLocalizacion> programacionAmbitoLocalizacionDtoToProgramacionAmbitoLocalizacion(List<ProgramacionAmbitoLocalizacionDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "programacionAmbito.id", source = "srcProgramacionAmbito.id")
    public abstract ProgramacionAmbitoLocalizacion mergeProgramacionAmbitoLocalizacionDtoAndProgramacionDtoToProgramacionAmbitoLocalizacion(
            ProgramacionAmbitoLocalizacionDto srcProgramacionAmbitoLocalizacion, ProgramacionAmbitoDto srcProgramacionAmbito);

    public List<ProgramacionAmbitoLocalizacion> mergeProgramacionAmbitoLocalizacionDtoAndProgramacionDtoToProgramacionAmbitoLocalizacion(
            List<ProgramacionAmbitoLocalizacionDto> srcProgramacionAmbitoLocalizacion, ProgramacionAmbitoDto srcProgramacionAmbito) {
        throw new UnsupportedOperationException("Not implemented");
    }
    
}
