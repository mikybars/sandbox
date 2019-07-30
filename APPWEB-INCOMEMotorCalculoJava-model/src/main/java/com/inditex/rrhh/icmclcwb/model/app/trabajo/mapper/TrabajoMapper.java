package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.Trabajo;

@Mapper(imports = { com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.Programacion.class })
public abstract class TrabajoMapper {

    @Mapping(target = "idProgramacion", expression = "java(src != null && src.getProgramacion() != null && src.getProgramacion().getId() != null ? src.getProgramacion().getId() : null)")
    public abstract TrabajoDto trabajoToTrabajoDto(Trabajo src);

    @Mapping(target = "programacion", expression = "java(src != null && src.getIdProgramacion() != null ? Programacion.builder().id(src.getIdProgramacion()).build() : null)")
    public abstract Trabajo trabajoDtoToTrabajo(TrabajoDto src);

    public abstract List<TrabajoDto> trabajoToTrabajoDto(List<Trabajo> src);

    public abstract List<Trabajo> trabajoDtoToTrabajo(List<TrabajoDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaHoraCreacion", ignore = true)
    @Mapping(target = "idProgramacion", source = "srcProgramacion.id")
    @Mapping(target = "tipoAmbito", source = "srcProgramacion.tipoAmbito")
    @Mapping(target = "nombreUsuario", source = "srcProgramacion.nombreUsuario")
    @Mapping(target = "icmIdPeriodo", source = "srcPeriodo.id")
    @Mapping(target = "fechaInicioPeriodo", source = "srcPeriodo.fechaInicioPeriodo")
    @Mapping(target = "fechaFinPeriodo", source = "srcPeriodo.fechaFinPeriodo")
    @Mapping(target = "idOrganization", source = "srcProgramacionAmbito.idOrgenization")
    public abstract TrabajoDto mergeProgramacionAmbitoDtoAndProgramacionDtoAndPeriodoDtoToTrabajoDto(
            ProgramacionAmbitoDto srcProgramacionAmbito, ProgramacionDto srcProgramacion, PeriodoDto srcPeriodo);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idTrabajo", ignore = true)
    public abstract TrabajoAmbitoOrigenDto programacionAmbitoOrigenDtoToTrabajoAmbitoOrigenDto(
            ProgramacionAmbitoOrigenDto src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idTrabajo", ignore = true)
    public abstract TrabajoAmbitoEmpresaDto programacionAmbitoEmpresaDtoToTrabajoAmbitoEmpresaDto(
            ProgramacionAmbitoEmpresaDto src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idTrabajo", ignore = true)
    public abstract TrabajoAmbitoLocalizacionDto programacionAmbitoLocalizacionDtoToTrabajoAmbitoLocalizacionDto(
            ProgramacionAmbitoLocalizacionDto src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idTrabajo", ignore = true)
    public abstract TrabajoAmbitoPersonaDto programacionAmbitoPersonaDtoToTrabajoAmbitoPersonaDto(
            ProgramacionAmbitoPersonaDto src);

}
