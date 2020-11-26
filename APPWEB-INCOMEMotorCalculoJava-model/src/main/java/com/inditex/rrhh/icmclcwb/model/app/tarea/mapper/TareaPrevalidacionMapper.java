package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPrevalidacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TareaPrevalidacionMapper {

    @Mapping(source = "src.id", target = "pk.id")
    @Mapping(source = "tarea.id", target = "pk.tarea.id")
    @Mapping(source = "src.idEstadoTareaPrevalidacion", target = "estado.id")
    @Mapping(source = "src.fechaHoraCreacion", target = "fechaHoraCreacion")
    @Mapping(source = "src.fechaHoraActualizacion", target = "fechaHoraActualizacion")
    @Mapping(source = "src.fechaHoraInicio", target = "fechaHoraInicio")
    @Mapping(source = "src.fechaHoraFin", target = "fechaHoraFin")
    @Mapping(source = "src.activo", target = "activo")
    public abstract TareaPrevalidacion tareaPrevalidacionDtotoTareaPrevalidacion(
            TareaPrevalidacionDto src, TareaDto tarea);

    @Mapping(source = "src.pk.id", target = "id")
    @Mapping(source = "tarea.id", target = "idTarea")
    @Mapping(source = "src.estado.id", target = "idEstadoTareaPrevalidacion")
    @Mapping(source = "src.fechaHoraCreacion", target = "fechaHoraCreacion")
    @Mapping(source = "src.fechaHoraActualizacion", target = "fechaHoraActualizacion")
    @Mapping(source = "src.fechaHoraInicio", target = "fechaHoraInicio")
    @Mapping(source = "src.fechaHoraFin", target = "fechaHoraFin")
    @Mapping(source = "src.activo", target = "activo")
    public abstract TareaPrevalidacionDto tareaPrevalidaciontoTareaPrevalidacionDto(
            TareaPrevalidacion src, TareaDto tarea);

}
