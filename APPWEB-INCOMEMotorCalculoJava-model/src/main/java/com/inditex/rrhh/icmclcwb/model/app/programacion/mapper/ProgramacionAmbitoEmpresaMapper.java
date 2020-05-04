package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.decorator.ProgramacionAmbitoEmpresaMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoEmpresa;

@Mapper
@DecoratedWith(value = ProgramacionAmbitoEmpresaMapperDecorator.class)
public abstract class ProgramacionAmbitoEmpresaMapper {

    @Mapping(target = "idProgramacionAmbito", source = "programacionAmbito.id")
    public abstract ProgramacionAmbitoEmpresaDto programacionAmbitoEmpresaToProgramacionAmbitoEmpresaDto(
            ProgramacionAmbitoEmpresa src);

    @InheritInverseConfiguration
    public abstract ProgramacionAmbitoEmpresa programacionAmbitoEmpresaDtoToProgramacionAmbitoEmpresa(
            ProgramacionAmbitoEmpresaDto src);

    public abstract List<ProgramacionAmbitoEmpresaDto> programacionAmbitoEmpresaToProgramacionAmbitoEmpresaDto(
            List<ProgramacionAmbitoEmpresa> src);

    public abstract List<ProgramacionAmbitoEmpresa> programacionAmbitoEmpresaDtoToProgramacionAmbitoEmpresa(
            List<ProgramacionAmbitoEmpresaDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "programacionAmbito.id", source = "srcProgramacionAmbito.id")
    public abstract ProgramacionAmbitoEmpresa mergeProgramacionAmbitoEmpresaDtoAndProgramacionDtoToProgramacionAmbitoEmpresa(
            ProgramacionAmbitoEmpresaDto srcProgramacionAmbitoEmpresa, ProgramacionAmbitoDto srcProgramacionAmbito);

    public List<ProgramacionAmbitoEmpresa> mergeProgramacionAmbitoEmpresaDtoAndProgramacionDtoToProgramacionAmbitoEmpresa(
            List<ProgramacionAmbitoEmpresaDto> srcProgramacionAmbitoEmpresa,
            ProgramacionAmbitoDto srcProgramacionAmbito) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

}
