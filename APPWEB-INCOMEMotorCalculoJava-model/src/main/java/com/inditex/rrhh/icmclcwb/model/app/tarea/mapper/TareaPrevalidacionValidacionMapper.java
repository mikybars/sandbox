package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionValidacionDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPrevalidacionValidacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TareaPrevalidacionValidacionMapper {

    @Mapping(source = "src.idTipoValidacion", target = "pk.tipoValidacion.id")
    @Mapping(source = "tarea.id", target = "pk.tareaPrevalidacion.pk.tarea.id")
    @Mapping(source = "src.idTareaPrevalidacion", target = "pk.tareaPrevalidacion.pk.id")
    @Mapping(source = "src.delay", target = "delay")
    @Mapping(source = "src.reintentoMax", target = "reintentoMax")
    @Mapping(source = "src.reintentoDelay", target = "reintentoDelay")
    @Mapping(source = "src.idTipoEstadoValidacion", target = "tipoEstadoValidacion.id")
    @Mapping(source = "src.idTipoAccionValidacion", target = "tipoAccionValidacion.id")
    @Mapping(source = "src.idPrioridadValidacion", target = "prioridadValidacion.id")
    @Mapping(source = "src.idEstadoValidacion", target = "estadoValidacion.id")
    @Mapping(source = "src.mensaje", target = "mensaje")
    @Mapping(source = "src.fechaHoraCreacion", target = "fechaHoraCreacion")
    @Mapping(source = "src.fechaHoraActualizacion", target = "fechaHoraActualizacion")
    public abstract TareaPrevalidacionValidacion tareaPrevalidacionValidacionDtotoTareaPrevalidacionValidacion(
            TareaPrevalidacionValidacionDto src, TareaDto tarea);

}
