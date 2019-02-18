package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaEmpleadoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleado;

@Mapper
@DecoratedWith(TareaEmpleadoDecorator.class)
public abstract class TareaEmpleadoMapper {

	@Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaEmpleadoDto tareaEmpleadoToTareaEmpleadoDto(TareaEmpleado src);

    @InheritInverseConfiguration
    public abstract TareaEmpleado tareaEmpleadoDtoToTareaEmpleado(TareaEmpleadoDto src);

    public abstract List<TareaEmpleadoDto> tareaEmpleadoToTareaEmpleadoDto(List<TareaEmpleado> src);

    public abstract List<TareaEmpleado> tareaEmpleadoDtoToTareaEmpleado(List<TareaEmpleadoDto> src);

    @Mapping(target = "id", source = "srcTareaEmpleadoDto.id")
    @Mapping(target = "idEmpleado", source = "srcTareaEmpleadoDto.idEmpleado")
    @Mapping(target = "tarea.id", source = "srcTareaDto.id")
    public abstract TareaEmpleado mergeTareaEmpleadoDtoAndTareaDtoToTareaEmpleado(
            TareaEmpleadoDto srcTareaEmpleadoDto, TareaDto srcTareaDto);

    public List<TareaEmpleado> mergeTareaEmpleadoDtoAndTareaDtoToTareaEmpleado(
            List<TareaEmpleadoDto> srcTareaEmpleadoDto, TareaDto srcTareaDto) {
        throw new UnsupportedOperationException("Not implemented");
    }

}