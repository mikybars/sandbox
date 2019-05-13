package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaCoeficienteDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaPersonaCoeficienteDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaCoeficiente;

@Mapper
@DecoratedWith(TareaPersonaCoeficienteDecorator.class)
public abstract class TareaPersonaCoeficienteMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaPersonaCoeficienteDto tareaPersonaCoeficienteToTareaPersonaCoeficienteDto(
            TareaPersonaCoeficiente src);

    @InheritInverseConfiguration
    public abstract TareaPersonaCoeficiente tareaPersonaCoeficienteDtoToTareaPersonaCoeficiente(
            TareaPersonaCoeficienteDto src);

    public abstract List<TareaPersonaCoeficienteDto> tareaPersonaCoeficienteToTareaPersonaCoeficienteDto(
            List<TareaPersonaCoeficiente> src);

    public abstract List<TareaPersonaCoeficiente> tareaPersonaCoeficienteDtoToPersonaCoeficiente(
            List<TareaPersonaCoeficienteDto> src);
    
    @Mapping(source = "src.idEmpleado", target = "idPersona")
    @Mapping(source = "src.orEmpleado", target = "orPersona")
    @Mapping(source = "src.idEmpleadoLocal", target = "idPersonaLocal")
    @Mapping(source = "src.fechaInicio", target = "fechaInicio")
    @Mapping(source = "src.fechaFin", target = "fechaFin")
    @Mapping(source = "src.coefJornada", target = "coeficiente")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaPersonaCoeficiente genericEmpleadoResultItemDtoToTareaPersonaCoeficiente( 
            GenericEmpleadoResultItemDto src, TareaDto tareaDto);

    public List<TareaPersonaCoeficiente> genericEmpleadoResultItemDtoToTareaPersonaCoeficiente(
            List<GenericEmpleadoResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
}
