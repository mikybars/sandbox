package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confprevalid.ConfPreValidResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaPrevalidacionValidacionDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPrevalidacionValidacion;
import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(value = TareaPrevalidacionValidacionDecorator.class)
public abstract class TareaPrevalidacionValidacionMapper {

    @Mapping(target = "idTarea", source = "pk.tareaPrevalidacion.pk.tarea.id")
    public abstract TareaPrevalidacionValidacionDto tareaPrevalidacionValidacionToTareaPrevalidacionValidacionDto(
            TareaPrevalidacionValidacion src);

    @InheritInverseConfiguration
    public abstract TareaPrevalidacionValidacion tareaPrevalidacionValidacionDtoToTareaPrevalidacionValidacion(
            TareaPrevalidacionValidacionDto src);

    public abstract List<TareaPrevalidacionValidacionDto> tareaPrevalidacionValidacionToTareaPrevalidacionValidacionDto(
            List<TareaPrevalidacionValidacion> src);

    public abstract List<TareaPrevalidacionValidacion> tareaPrevalidacionValidacionDtoToTareaPrevalidacionValidacion(
            List<TareaPrevalidacionValidacionDto> src);

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

    @Mapping(source = "src.idValidacion", target = "idTipoValidacion")
    @Mapping(source = "tareaPrevalidacion.idTarea", target = "idTarea")
    @Mapping(source = "src.delay", target = "delay")
    @Mapping(source = "src.reintentoMax", target = "reintentoMax")
    @Mapping(source = "src.delayTiempo", target = "reintentoDelay")
    @Mapping(source = "src.idEstado", target = "idTipoEstadoValidacion")
    @Mapping(source = "src.idAccion", target = "idTipoAccionValidacion")
    @Mapping(source = "tareaPrevalidacion.id", target = "idTareaPrevalidacion")
    @Mapping(target = "mensaje", ignore = true)
    @Mapping(target = "fechaHoraCreacion", ignore = true)
    @Mapping(target = "fechaHoraActualizacion", ignore = true)
    @Mapping(target = "idPrioridadValidacion", ignore = true)
    @Mapping(target = "idEstadoValidacion", ignore = true)
    public abstract TareaPrevalidacionValidacionDto confPreValidResultItemDtotoTareaPrevalidacionValidacionDto(
            ConfPreValidResultItemDto src, TareaPrevalidacionDto tareaPrevalidacion);

    public List<TareaPrevalidacionValidacionDto> confPreValidResultItemDtotoTareaPrevalidacionValidacionDto(
            final List<ConfPreValidResultItemDto> src, final TareaPrevalidacionDto tareaPrevalidacion) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

}
