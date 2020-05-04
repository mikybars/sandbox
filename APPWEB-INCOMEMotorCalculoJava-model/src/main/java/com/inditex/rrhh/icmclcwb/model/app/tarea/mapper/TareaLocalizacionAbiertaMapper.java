package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionAbiertaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionAbierta;

@Mapper
public abstract class TareaLocalizacionAbiertaMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaLocalizacionAbiertaDto tareaLocalizacionAbiertaToTareaLocalizacionAbiertaDto(
            TareaLocalizacionAbierta src);

    @InheritInverseConfiguration
    public abstract TareaLocalizacionAbierta tareaLocalizacionAbiertaDtoToTareaLocalizacionAbierta(
            TareaLocalizacionAbiertaDto src);

    public abstract List<TareaLocalizacionAbiertaDto> tareaLocalizacionAbiertaToTareaLocalizacionAbiertaDto(
            List<TareaLocalizacionAbierta> src);

    public abstract List<TareaLocalizacionAbierta> tareaLocalizacionAbiertaDtoToLocalizacionAbierta(
            List<TareaLocalizacionAbiertaDto> src);

}
