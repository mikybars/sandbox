package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalPersona;

@Mapper
public abstract class TareaPersonaMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaPersonaDto tareaPersonaToTareaPersonaDto(TareaAmbitoGlobalPersona src);

    @InheritInverseConfiguration
    public abstract TareaAmbitoGlobalPersona tareaPersonaDtoToTareaPersona(TareaPersonaDto src);

    public abstract List<TareaPersonaDto> tareaPersonaToTareaPersonaDto(List<TareaAmbitoGlobalPersona> src);

    public abstract List<TareaAmbitoGlobalPersona> tareaPersonaDtoToTareaPersona(List<TareaPersonaDto> src);

}
