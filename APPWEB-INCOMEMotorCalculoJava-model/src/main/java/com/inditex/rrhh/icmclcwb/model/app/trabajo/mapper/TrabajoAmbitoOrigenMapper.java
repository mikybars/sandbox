package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator.TrabajoAmbitoOrigenMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoAmbitoOrigen;

@Mapper
@DecoratedWith(value = TrabajoAmbitoOrigenMapperDecorator.class)
public abstract class TrabajoAmbitoOrigenMapper {

    @Mapping(target = "idTrabajo", source = "trabajo.id")
    public abstract TrabajoAmbitoOrigenDto trabajoAmbitoOrigenToTrabajoAmbitoOrigenDto(TrabajoAmbitoOrigen src);

    @InheritInverseConfiguration
    public abstract TrabajoAmbitoOrigen trabajoAmbitoOrigenDtoToTrabajoAmbitoOrigen(TrabajoAmbitoOrigenDto src);

    public abstract List<TrabajoAmbitoOrigenDto> trabajoAmbitoOrigenToTrabajoAmbitoOrigenDto(
            List<TrabajoAmbitoOrigen> src);

    public abstract List<TrabajoAmbitoOrigen> trabajoAmbitoOrigenDtoToTrabajoAmbitoOrigen(
            List<TrabajoAmbitoOrigenDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "trabajo.id", source = "srcTrabajo.id")
    public abstract TrabajoAmbitoOrigen mergeTrabajoAmbitoOrigenDtoAndTrabajoDtoToTrabajoAmbitoOrigen(
            TrabajoAmbitoOrigenDto srcTrabajoAmbitoOrigen, TrabajoDto srcTrabajo);

    public List<TrabajoAmbitoOrigen> mergeTrabajoAmbitoOrigenDtoAndTrabajoDtoToTrabajoAmbitoOrigen(
            List<TrabajoAmbitoOrigenDto> srcTrabajoAmbitoOrigen, TrabajoDto srcTrabajo) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

}
