package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.decorator.TrabajoEmpleadoEstructuraDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstructura;

@Mapper
@DecoratedWith(value = TrabajoEmpleadoEstructuraDecorator.class)
public abstract class TrabajoEmpleadoEstructuraMapper {
    
    @Mapping(target = "idTrabajo", source = "trabajo.id")
    public abstract TrabajoEmpleadoEstructuraDto trabajoEmpleadoEstructuraToTrabajoEmpleadoEstructuraDto(TrabajoEmpleadoEstructura src);

    @InheritInverseConfiguration
    public abstract TrabajoEmpleadoEstructura trabajoEmpleadoEstructuraDtoToTrabajoEmpleadoEstructura(TrabajoEmpleadoEstructuraDto src);

    public abstract List<TrabajoEmpleadoEstructuraDto> trabajoEmpleadoEstructuraToTrabajoEmpleadoEstructuraDto(
            List<TrabajoEmpleadoEstructura> src);

    public abstract List<TrabajoEmpleadoEstructura> trabajoEmpleadoEstructuraDtoToTrabajoEmpleadoEstructura(
            List<TrabajoEmpleadoEstructuraDto> src);
    
    @Mapping(target = "trabajo.id", source = "srcTrabajo.id")
    @Mapping(target = "id", ignore = true)
    public abstract TrabajoEmpleadoEstructura mergeTrabajoEmpleadoEstructuraDtoAndTrabajoDtoToTrabajoEmpleadoEstructura(
            TrabajoEmpleadoEstructuraDto srcTrabajoEmpleadoEstructura, TrabajoDto srcTrabajo);

    public List<TrabajoEmpleadoEstructura> mergeTrabajoEmpleadoEstructuraDtoAndTrabajoDtoToTrabajoEmpleadoEstructura(
            List<TrabajoEmpleadoEstructuraDto> srcTrabajoEmpleadoEstructura, TrabajoDto srcTrabajoDto) {
        throw new UnsupportedOperationException("Not implemented");
    }
    
    @Mapping(target = "idEmpleado", source = "src.idEmpleado")
    public abstract TrabajoEmpleadoEstructuraDto genericEmpleadoResultItemDtoToTrabajoEmpleadoEstructuraDto(
            GenericEmpleadoResultItemDto src, TrabajoDto trabajo);

    public List<TrabajoEmpleadoEstructuraDto> genericEmpleadoResultItemDtoToTrabajoEmpleadoEstructuraDto(
            List<GenericEmpleadoResultItemDto> src, TrabajoDto trabajo) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
