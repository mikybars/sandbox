package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraPoliticaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaPersonaEstructuraPoliticaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPolitica;
import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
@DecoratedWith(value = TareaPersonaEstructuraPoliticaDecorator.class)
public abstract class TareaPersonaEstructuraPoliticaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tarea.id", source = "idTarea")
    @Mapping(target = "idOrigen", source = "idOrigen")
    @Mapping(target = "idPersona", source = "idPersona")
    @Mapping(target = "orPersona", source = "orPersona")
    @Mapping(target = "idPersonaLocal", source = "idPersonaLocal")
    @Mapping(target = "idEstructuraPolitica", source = "idEstructuraPolitica")
    @Mapping(target = "fechaInicio", source = "fechaInicio")
    @Mapping(target = "fechaFin", source = "fechaFin")
    @Mapping(target = "excluidoDenominador", source = "excluidoDenominador")
    @Mapping(target = "tipoPolitica", ignore = true)
    public abstract TareaPersonaEstructuraPolitica tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPolitica(
        TareaPersonaEstructuraPoliticaDto src);

    @InheritInverseConfiguration
    public abstract TareaPersonaEstructuraPoliticaDto tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(
        TareaPersonaEstructuraPolitica src);

    public List<TareaPersonaEstructuraPolitica> tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPolitica(
            List<TareaPersonaEstructuraPoliticaDto> src) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    public List<TareaPersonaEstructuraPoliticaDto> tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(
            List<TareaPersonaEstructuraPolitica> src) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tarea.id", source = "tarea.id")
    @Mapping(target = "idOrigen", source = "src.idOrigen")
    @Mapping(target = "idPersona", source = "src.idEmpleado")
    @Mapping(target = "orPersona", source = "src.orEmpleado")
    @Mapping(target = "idPersonaLocal", source = "src.idEmpleadoLocal")
    @Mapping(target = "idEstructuraPolitica", source = "src.idEstructura")
    @Mapping(target = "fechaInicio", source = "src.fechaInicio")
    @Mapping(target = "fechaFin", source = "src.fechaFin")
    @Mapping(target = "excluidoDenominador", source = "src.excDenominador")
    @Mapping(target = "tipoPolitica", ignore = true)
    public abstract TareaPersonaEstructuraPolitica comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(
        ComisionEmpleadoResultItemDto src, TareaDto tarea);

    public List<TareaPersonaEstructuraPolitica> comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(
        List<ComisionEmpleadoResultItemDto> src, TareaDto tarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

}
