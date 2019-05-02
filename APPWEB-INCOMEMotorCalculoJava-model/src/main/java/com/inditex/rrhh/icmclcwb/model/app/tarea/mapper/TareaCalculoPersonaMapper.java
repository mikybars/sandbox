package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCalculoPersona;

@Mapper
public abstract class TareaCalculoPersonaMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaCalculoPersonaDto tareaCalculoPersonaToTareaCalculoPersonaDto(
            TareaCalculoPersona src);

    @InheritInverseConfiguration
    public abstract TareaCalculoPersona tareaCalculoPersonaDtoToTareaCalculoPersona(
            TareaCalculoPersonaDto src);

    public abstract List<TareaCalculoPersonaDto> tareaCalculoPersonaToTareaCalculoPersonaDto(
            List<TareaCalculoPersona> src);

    public abstract List<TareaCalculoPersona> tareaCalculoPersonaDtoToTareaCalculoPersona(
            List<TareaCalculoPersonaDto> src);
    
}
