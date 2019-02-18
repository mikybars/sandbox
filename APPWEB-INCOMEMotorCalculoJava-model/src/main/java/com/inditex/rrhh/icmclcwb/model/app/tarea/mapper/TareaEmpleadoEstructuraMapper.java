package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaEmpleadoEstructuraDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoEstructura;

@Mapper
@DecoratedWith(value = TareaEmpleadoEstructuraDecorator.class)
public abstract class TareaEmpleadoEstructuraMapper {
    
    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaEmpleadoEstructuraDto tareaEmpleadoEstructuraToTareaEmpleadoEstructuraDto(TareaEmpleadoEstructura src);

    @InheritInverseConfiguration
    public abstract TareaEmpleadoEstructura tareaEmpleadoEstructuraDtoToTareaEmpleadoEstructura(TareaEmpleadoEstructuraDto src);

    public abstract List<TareaEmpleadoEstructuraDto> tareaEmpleadoEstructuraToTareaEmpleadoEstructuraDto(
            List<TareaEmpleadoEstructura> src);

    public abstract List<TareaEmpleadoEstructura> tareaEmpleadoEstructuraDtoToTareaEmpleadoEstructura(
            List<TareaEmpleadoEstructuraDto> src);
    
    @Mapping(target = "tarea.id", source = "srcTarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaEmpleadoEstructura mergeTareaEmpleadoEstructuraDtoAndTareaDtoToTareaEmpleadoEstructura(
            TareaEmpleadoEstructuraDto srcTareaEmpleadoEstructura, TareaDto srcTarea);

    public List<TareaEmpleadoEstructura> mergeTareaEmpleadoEstructuraDtoAndTareaDtoToTareaEmpleadoEstructura(
            List<TareaEmpleadoEstructuraDto> srcTareaEmpleadoEstructura, TareaDto srcTareaDto) {
        throw new UnsupportedOperationException("Not implemented");
    }
    
    @Mapping(target = "idEmpleado", source = "src.idEmpleado")
    public abstract TareaEmpleadoEstructuraDto genericEmpleadoResultItemDtoToTareaEmpleadoEstructuraDto(
            GenericEmpleadoResultItemDto src, TareaDto tarea);

    public List<TareaEmpleadoEstructuraDto> genericEmpleadoResultItemDtoToTareaEmpleadoEstructuraDto(
            List<GenericEmpleadoResultItemDto> src, TareaDto tarea) {
        throw new UnsupportedOperationException("Not implemented");
    }       
}
