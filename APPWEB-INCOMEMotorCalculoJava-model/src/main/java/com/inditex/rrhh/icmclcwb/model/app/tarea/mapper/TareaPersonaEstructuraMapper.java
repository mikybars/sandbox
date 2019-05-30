package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaPersonaEstructuraDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructura;

@Mapper(imports = org.apache.commons.lang3.StringUtils.class)
@DecoratedWith(value = TareaPersonaEstructuraDecorator.class)
public abstract class TareaPersonaEstructuraMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaPersonaEstructuraDto tareaPersonaEstructuraToTareaPersonaEstructuraDto(
            TareaPersonaEstructura src);

    @InheritInverseConfiguration
    public abstract TareaPersonaEstructura tareaPersonaEstructuraDtoToTareaPersonaEstructura(
            TareaPersonaEstructuraDto src);

    public abstract List<TareaPersonaEstructuraDto> tareaPersonaEstructuraToTareaPersonaEstructuraDto(
            List<TareaPersonaEstructura> src);

    public abstract List<TareaPersonaEstructura> tareaPersonaEstructuraDtoToTareaPersonaEstructura(
            List<TareaPersonaEstructuraDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tarea.id", source = "srcTarea.id")
    public abstract TareaPersonaEstructura mergeTareaPersonaEstructuraDtoAndTareaDtoToTareaPersonaEstructura(
            TareaPersonaEstructuraDto srcTareaPersonaEstructura, TareaDto srcTarea);

    public List<TareaPersonaEstructura> mergeTareaPersonaEstructuraDtoAndTareaDtoToTareaPersonaEstructura(
            List<TareaPersonaEstructuraDto> srcTareaPersonaEstructura, TareaDto srcTareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idTarea", ignore = true)
    @Mapping(target = "idPersona", source = "src.idPersona")
    @Mapping(target = "orPersona", source = "src.orPersona")
    @Mapping(target = "idPersonaLocal", source = "src.idPersonaLocal")
    @Mapping(target = "fechaInicio", source = "src.fechaInicio")
    @Mapping(target = "idOrigen", source = "src.idOrigen")
    @Mapping(target = "fechaFin", source = "src.fechaFin")
    @Mapping(target = "idTipoCalculo", source = "src.idTipoCalculo")
    @Mapping(target = "idTipoComision", source = "src.idTipoComision")
    public abstract TareaPersonaEstructuraDto comisionEmpleadoResultItemDtoToTareaPersonaEstructuraDto(
            final ComisionEmpleadoResultItemDto src);

    public List<TareaPersonaEstructuraDto> comisionEmpleadoResultItemDtoToTareaPersonaEstructuraDto(
            List<ComisionEmpleadoResultItemDto> src){
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

}
