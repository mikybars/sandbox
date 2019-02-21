package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator.TrabajoAmbitoLocalizacionMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoAmbitoLocalizacion;

@Mapper
@DecoratedWith(value = TrabajoAmbitoLocalizacionMapperDecorator.class)
public abstract class TrabajoAmbitoLocalizacionMapper {

    @Mapping(target = "idTrabajo", source = "trabajo.id")
    public abstract TrabajoAmbitoLocalizacionDto trabajoAmbitoLocalizacionToTrabajoAmbitoLocalizacionDto(TrabajoAmbitoLocalizacion src);

    @InheritInverseConfiguration
    public abstract TrabajoAmbitoLocalizacion trabajoAmbitoLocalizacionDtoToTrabajoAmbitoLocalizacion(TrabajoAmbitoLocalizacionDto src);

    public abstract List<TrabajoAmbitoLocalizacionDto> trabajoAmbitoLocalizacionToTrabajoAmbitoLocalizacionDto(
            List<TrabajoAmbitoLocalizacion> src);

    public abstract List<TrabajoAmbitoLocalizacion> trabajoAmbitoLocalizacionDtoToTrabajoAmbitoLocalizacion(
            List<TrabajoAmbitoLocalizacionDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "trabajo.id", source = "srcTrabajo.id")
    public abstract TrabajoAmbitoLocalizacion mergeTrabajoAmbitoLocalizacionDtoAndTrabajoDtoToTrabajoAmbitoLocalizacion(
            TrabajoAmbitoLocalizacionDto srcTrabajoAmbitoLocalizacion, TrabajoDto srcTrabajo);

    public List<TrabajoAmbitoLocalizacion> mergeTrabajoAmbitoLocalizacionDtoAndTrabajoDtoToTrabajoAmbitoLocalizacion(
            List<TrabajoAmbitoLocalizacionDto> srcTrabajoAmbitoLocalizacion, TrabajoDto srcTrabajo) {
        throw new UnsupportedOperationException("Not implemented");
    }

}
