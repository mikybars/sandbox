package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.decorator.TrabajoEmpleadoEstadoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstado;

@Mapper
@DecoratedWith(TrabajoEmpleadoEstadoDecorator.class)
public abstract class TrabajoEmpleadoEstadoMapper {

	@Mapping(target = "idTrabajo", source = "trabajo.id")
    public abstract TrabajoEmpleadoEstadoDto trabajoEmpleadoEstadoToTrabajoEmpleadoEstadoDto(TrabajoEmpleadoEstado src);

    @InheritInverseConfiguration
    public abstract TrabajoEmpleadoEstado trabajoEmpleadoEstadoDtoToTrabajoEmpleadoEstado(TrabajoEmpleadoEstadoDto src);

    public abstract List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstadoToTrabajoEmpleadoEstadoDto(
            List<TrabajoEmpleadoEstado> src);

    public abstract List<TrabajoEmpleadoEstado> trabajoEmpleadoEstadoDtoToTrabajoEmpleadoEstado(
            List<TrabajoEmpleadoEstadoDto> src);

    @Mapping(target = "idEmpleado", source = "src.idEmpleado")
    @Mapping(target = "idTrabajo", source = "trabajo.id")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", ignore = true)
    public abstract TrabajoEmpleadoEstadoDto empleadosTiendaResultItemDtoToTrabajoEmpleadoEstadoDto(
            EmpleadosTiendaResultItemDto src, TrabajoDto trabajo);

    public List<TrabajoEmpleadoEstadoDto> empleadosTiendaResultItemDtoToTrabajoEmpleadoEstadoDto(
            List<EmpleadosTiendaResultItemDto> src, TrabajoDto trabajo) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Mapping(target = "idEmpleado", source = "src.idEmpleado")
    @Mapping(target = "orEmpleado", source = "src.orEmpleado")
    @Mapping(target = "idTrabajo", source = "trabajo.id")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", ignore = true)
    public abstract TrabajoEmpleadoEstadoDto genericEmpleadoResultItemDtoToTrabajoEmpleadoEstadoDto(
            GenericEmpleadoResultItemDto src, TrabajoDto trabajo);

    public List<TrabajoEmpleadoEstadoDto> genericEmpleadoResultItemDtoToTrabajoEmpleadoEstadoDto(
            List<GenericEmpleadoResultItemDto> src, TrabajoDto trabajo) {
        throw new UnsupportedOperationException("Not implemented");
    }

}