package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator.TrabajoEmpleadoEstadoDecorator;
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
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "trabajo.id", source = "srcTrabajoDto.id")
	@Mapping(target = "idEmpleado", source = "srcTrabajoEmpleadoEstadoDto.idEmpleado")
	@Mapping(target = "orEmpleado", source = "srcTrabajoEmpleadoEstadoDto.orEmpleado")
	public abstract TrabajoEmpleadoEstado mergeTrabajoEmpleadoEstadoDtoAndTrabajoDtoToTrabajoEmpleadoEstado(
			TrabajoEmpleadoEstadoDto srcTrabajoEmpleadoEstadoDto, TrabajoDto srcTrabajoDto);
   
	public List<TrabajoEmpleadoEstado> mergeTrabajoEmpleadoEstadoDtoAndTrabajoDtoToTrabajoEmpleadoEstado(
            List<TrabajoEmpleadoEstadoDto> srcTrabajoEmpleadoEstadoDto, TrabajoDto srcTrabajoDto) {
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