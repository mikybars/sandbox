package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLimpieza;

@Mapper
public abstract class TareaLimpiezaMapper {

    @Mapping(target = "idTarea", source = "id")
    public abstract TareaLimpiezaDto tareaLimpiezaToTareaLimpiezaDto(TareaLimpieza src);

    @InheritInverseConfiguration
    public abstract TareaLimpieza tareaLimpiezaDtoToTareaLimpieza(TareaLimpiezaDto src);

    public abstract List<TareaLimpiezaDto> tareaLimpiezaToTareaLimpiezaDto(List<TareaLimpieza> src);

    public abstract List<TareaLimpieza> tareaLimpiezaDtoToTareaLimpieza(List<TareaLimpiezaDto> src);

}
