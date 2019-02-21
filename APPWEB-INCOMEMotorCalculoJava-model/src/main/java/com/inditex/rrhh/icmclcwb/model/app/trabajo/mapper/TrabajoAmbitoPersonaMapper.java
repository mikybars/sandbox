package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator.TrabajoAmbitoPersonaMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoAmbitoPersona;

@Mapper
@DecoratedWith(value = TrabajoAmbitoPersonaMapperDecorator.class)
public abstract class TrabajoAmbitoPersonaMapper {

    @Mapping(target = "idTrabajo", source = "trabajo.id")
    public abstract TrabajoAmbitoPersonaDto trabajoAmbitoPersonaToTrabajoAmbitoPersonaDto(TrabajoAmbitoPersona src);

    @InheritInverseConfiguration
    public abstract TrabajoAmbitoPersona trabajoAmbitoPersonaDtoToTrabajoAmbitoPersona(TrabajoAmbitoPersonaDto src);

    public abstract List<TrabajoAmbitoPersonaDto> trabajoAmbitoPersonaToTrabajoAmbitoPersonaDto(
            List<TrabajoAmbitoPersona> src);

    public abstract List<TrabajoAmbitoPersona> trabajoAmbitoPersonaDtoToTrabajoAmbitoPersona(
            List<TrabajoAmbitoPersonaDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "trabajo.id", source = "srcTrabajo.id")
    public abstract TrabajoAmbitoPersona mergeTrabajoAmbitoPersonaDtoAndTrabajoDtoToTrabajoAmbitoPersona(
            TrabajoAmbitoPersonaDto srcTrabajoAmbitoPersona, TrabajoDto srcTrabajo);

    public List<TrabajoAmbitoPersona> mergeTrabajoAmbitoPersonaDtoAndTrabajoDtoToTrabajoAmbitoPersona(
            List<TrabajoAmbitoPersonaDto> srcTrabajoAmbitoPersona, TrabajoDto srcTrabajo) {
        throw new UnsupportedOperationException("Not implemented");
    }

}
