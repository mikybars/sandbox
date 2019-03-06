package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaEmpleadoEstadoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoEstado;

@Mapper
@DecoratedWith(TareaEmpleadoEstadoDecorator.class)
public abstract class TareaEmpleadoEstadoMapper {

	@Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaEmpleadoEstadoDto tareaEmpleadoEstadoToTareaEmpleadoEstadoDto(TareaEmpleadoEstado src);

    @InheritInverseConfiguration
    public abstract TareaEmpleadoEstado tareaEmpleadoEstadoDtoToTareaEmpleadoEstado(TareaEmpleadoEstadoDto src);

    public abstract List<TareaEmpleadoEstadoDto> tareaEmpleadoEstadoToTareaEmpleadoEstadoDto(
            List<TareaEmpleadoEstado> src);

    public abstract List<TareaEmpleadoEstado> tareaEmpleadoEstadoDtoToTareaEmpleadoEstado(
            List<TareaEmpleadoEstadoDto> src);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "tarea.id", source = "srcTareaDto.id")
	@Mapping(target = "idEmpleado", source = "srcTareaEmpleadoEstadoDto.idEmpleado")
	@Mapping(target = "orEmpleado", source = "srcTareaEmpleadoEstadoDto.orEmpleado")
	public abstract TareaEmpleadoEstado mergeTareaEmpleadoEstadoDtoAndTareaDtoToTareaEmpleadoEstado(
			TareaEmpleadoEstadoDto srcTareaEmpleadoEstadoDto, TareaDto srcTareaDto);
   
	public List<TareaEmpleadoEstado> mergeTareaEmpleadoEstadoDtoAndTareaDtoToTareaEmpleadoEstado(
            List<TareaEmpleadoEstadoDto> srcTareaEmpleadoEstadoDto, TareaDto srcTareaDto) {
	    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(target = "idEmpleado", source = "src.idEmpleado")
    @Mapping(target = "orEmpleado", source = "src.orEmpleado")
    @Mapping(target = "idTarea", source = "tarea.id")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", ignore = true)
    public abstract TareaEmpleadoEstadoDto genericEmpleadoResultItemDtoToTareaEmpleadoEstadoDto(
            GenericEmpleadoResultItemDto src, TareaDto tarea);

    public List<TareaEmpleadoEstadoDto> genericEmpleadoResultItemDtoToTareaEmpleadoEstadoDto(
            List<GenericEmpleadoResultItemDto> src, TareaDto tarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

}