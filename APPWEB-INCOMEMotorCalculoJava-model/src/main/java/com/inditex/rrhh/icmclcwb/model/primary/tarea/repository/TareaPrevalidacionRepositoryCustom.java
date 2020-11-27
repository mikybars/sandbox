package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.dto.AccionValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPrevalidacion;

public interface TareaPrevalidacionRepositoryCustom {

    List<TareaPrevalidacion> save(List<TareaPrevalidacion> src);

    TareaPrevalidacionDto findMaxReintento(@NotNull @Positive Long idTarea);

    AccionValidacionDto findAccionValidacion(@NotNull @Positive Long idTarea,
            @NotNull @Positive Integer idTareaPrevalidacion);

    void updateFechaFin(@NotNull TareaPrevalidacionDto tareaPrevalidacionDto);

    void updateEstado(@NotNull TareaPrevalidacionDto tareaPrevalidacionDto,
            @NotNull EstadoTareaPrevalidacionDto estado);

    Boolean checkMaxReintentos(@NotNull TareaPrevalidacionDto tareaPrevalidacionDto);

}
