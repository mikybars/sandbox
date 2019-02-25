package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbito;

@Mapper
@DecoratedWith(value = TareaAmbitoMapperDecorator.class)
public abstract class TareaAmbitoMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaAmbitoDto tareaAmbitoToTareaAmbitoDto(TareaAmbito src);

    @InheritInverseConfiguration
    public abstract TareaAmbito tareaAmbitoDtoToTareaAmbito(TareaAmbitoDto src);

    public abstract List<TareaAmbitoDto> tareaAmbitoToTareaAmbitoDto(
            List<TareaAmbito> src);

    public abstract List<TareaAmbito> tareaAmbitoDtoToTareaAmbito(
            List<TareaAmbitoDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tarea.id", source = "srcTarea.id")
    public abstract TareaAmbito mergeTareaAmbitoDtoAndTareaDtoToTareaAmbito(
            TareaAmbitoDto srcTareaAmbito, TareaDto srcTarea);

    public List<TareaAmbito> mergeTareaAmbitoDtoAndTareaDtoToTareaAmbito(
            List<TareaAmbitoDto> srcTareaAmbito, TareaDto srcTarea) {
        throw new UnsupportedOperationException("Not implemented");
    }

}
