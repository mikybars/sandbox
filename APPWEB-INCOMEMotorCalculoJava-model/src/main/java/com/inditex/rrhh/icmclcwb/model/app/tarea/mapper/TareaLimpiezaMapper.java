package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLimpieza;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TareaLimpiezaMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    @Mapping(target = "estado.id", source = "estado.id")
    public abstract TareaLimpiezaDto tareaLimpiezaToTareaLimpiezaDto(TareaLimpieza src);

    @InheritInverseConfiguration
    public abstract TareaLimpieza tareaLimpiezaDtoToTareaLimpieza(TareaLimpiezaDto src);

    public abstract List<TareaLimpiezaDto> tareaLimpiezaToTareaLimpiezaDto(List<TareaLimpieza> src);

    public abstract List<TareaLimpieza> tareaLimpiezaDtoToTareaLimpieza(List<TareaLimpiezaDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "nombreUsuario", ignore = true)
    @Mapping(target = "idTarea", source = "id")
    @Mapping(target = "fechaHoraLimpieza", ignore = true)
    @Mapping(target = "esCompleta", constant = "true")
    @Mapping(target = "esParcial", constant = "false")
    @Mapping(target = "estado", ignore = true)
    public abstract TareaLimpiezaDto idTareaDtoToTareaLimpiezaDto(IdTareaDto src);

    public abstract List<TareaLimpiezaDto> idTareaDtoToTareaLimpiezaDto(
            final List<IdTareaDto> srcIdTarea);

}
