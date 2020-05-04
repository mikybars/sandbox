package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionFestivoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionFestivoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionFestivo;

@Mapper
@DecoratedWith(TareaLocalizacionFestivoDecorator.class)
public abstract class TareaLocalizacionFestivoMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaLocalizacionFestivoDto tareaLocalizacionFestivoToTareaLocalizacionFestivoDto(
            TareaLocalizacionFestivo src);

    @InheritInverseConfiguration
    public abstract TareaLocalizacionFestivo tareaLocalizacionFestivoDtoToTareaLocalizacionFestivo(
            TareaLocalizacionFestivoDto src);

    public abstract List<TareaLocalizacionFestivoDto> tareaLocalizacionFestivoToTareaLocalizacionFestivoDto(
            List<TareaLocalizacionFestivo> src);

    public abstract List<TareaLocalizacionFestivo> tareaLocalizacionFestivoDtoToLocalizacionFestivo(
            List<TareaLocalizacionFestivoDto> src);

    @Mapping(source = "src.idLugarTrabajo", target = "stdIdWorkLocat")
    @Mapping(source = "src.fechaFestivo", target = "fecha")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionFestivo genericTiendaResultItemDtoToTareaLocalizacionFestivo(
            GenericTiendaResultItemDto src, TareaDto tareaDto);

    public List<TareaLocalizacionFestivo> genericTiendaResultItemDtoToTareaLocalizacionFestivo(
            List<GenericTiendaResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

}
