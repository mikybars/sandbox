package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.decorator.TrabajoEmpleadoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleado;

@Mapper
@DecoratedWith(TrabajoEmpleadoDecorator.class)
public abstract class TrabajoEmpleadoMapper {

	@Mapping(target = "idTrabajo", source = "trabajo.id")
    public abstract TrabajoEmpleadoDto trabajoEmpleadoToTrabajoEmpleadoDto(TrabajoEmpleado src);

    @InheritInverseConfiguration
    public abstract TrabajoEmpleado trabajoEmpleadoDtoToTrabajoEmpleado(TrabajoEmpleadoDto src);

    public abstract List<TrabajoEmpleadoDto> trabajoEmpleadoToTrabajoEmpleadoDto(List<TrabajoEmpleado> src);

    public abstract List<TrabajoEmpleado> trabajoEmpleadoDtoToTrabajoEmpleado(List<TrabajoEmpleadoDto> src);

    @Mapping(target = "id", source = "srcTrabajoEmpleadoDto.id")
    @Mapping(target = "idEmpleado", source = "srcTrabajoEmpleadoDto.idEmpleado")
    @Mapping(target = "trabajo.id", source = "srcTrabajoDto.id")
    public abstract TrabajoEmpleado mergeTrabajoEmpleadoDtoAndTrabajoDtoToTrabajoEmpleado(
            TrabajoEmpleadoDto srcTrabajoEmpleadoDto, TrabajoDto srcTrabajoDto);

    public List<TrabajoEmpleado> mergeTrabajoEmpleadoDtoAndTrabajoDtoToTrabajoEmpleado(
            List<TrabajoEmpleadoDto> srcTrabajoEmpleadoDto, TrabajoDto srcTrabajoDto) {
        throw new UnsupportedOperationException("Not implemented");
    }

}