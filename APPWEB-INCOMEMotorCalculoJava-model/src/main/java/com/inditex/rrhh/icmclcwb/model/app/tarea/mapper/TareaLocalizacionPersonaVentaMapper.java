package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPersonaVentaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionPersonaVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVenta;

@Mapper
@DecoratedWith(TareaLocalizacionPersonaVentaDecorator.class)
public abstract class TareaLocalizacionPersonaVentaMapper {

    public abstract TareaLocalizacionPersonaVenta tareaLocalizacionPersonaVentaDtoToTareaLocalizacionPersonaVenta(
            TareaLocalizacionPersonaVentaDto src);

    public abstract List<TareaLocalizacionPersonaVenta> tareaLocalizacionPersonaVentaDtoToTareaLocalizacionPersonaVenta(
            List<TareaLocalizacionPersonaVentaDto> src);

    public abstract TareaLocalizacionPersonaVentaDto tareaLocalizacionPersonaVentaToTareaLocalizacionPersonaVentaDto(
            TareaLocalizacionPersonaVenta src);

    public abstract List<TareaLocalizacionPersonaVentaDto> tareaLocalizacionPersonaVentaToTareaLocalizacionPersonaVentaDto(
            List<TareaLocalizacionPersonaVenta> src);

}
