package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaEmpleadoEstructuraDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoEstructura;

@Mapper(imports = org.apache.commons.lang3.StringUtils.class)
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
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @Mapping(target = "idEmpleado", source = "src.idEmpleado")
    @Mapping(target = "porcentaje", expression = "java(StringUtils.isNotEmpty(src.getPercentageAll()) ? Double.parseDouble(src.getPercentageAll()) : 0)" )
    @Mapping(target = "porcentaje1", expression = "java(StringUtils.isNotEmpty(src.getPercentageWoman()) ? Double.parseDouble(src.getPercentageWoman()) : 0)")
    @Mapping(target = "porcentaje2", expression = "java(StringUtils.isNotEmpty(src.getPercentageMan()) ? Double.parseDouble(src.getPercentageMan()) : 0)")
    @Mapping(target = "porcentaje3", expression = "java(StringUtils.isNotEmpty(src.getPercentageBoy()) ? Double.parseDouble(src.getPercentageBoy()) : 0)")
    public abstract TareaEmpleadoEstructuraDto genericEmpleadoResultItemDtoToTareaEmpleadoEstructuraDto(
            GenericEmpleadoResultItemDto src, TareaDto tarea);

    public List<TareaEmpleadoEstructuraDto> genericEmpleadoResultItemDtoToTareaEmpleadoEstructuraDto(
            List<GenericEmpleadoResultItemDto> src, TareaDto tarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }       
}
