package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacion;

@Mapper
public abstract class TareaLocalizacionMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaLocalizacionDto tareaLocalizacionToTareaLocalizacionDto(TareaLocalizacion src);

    @InheritInverseConfiguration
    public abstract TareaLocalizacion tareaLocalizacionDtoToTareaLocalizacion(TareaLocalizacionDto src);

    public abstract List<TareaLocalizacionDto> tareaLocalizacionToTareaLocalizacionDto(List<TareaLocalizacion> src);

    public abstract List<TareaLocalizacion> tareaLocalizacionDtoToTareaLocalizacion(List<TareaLocalizacionDto> src);
}
