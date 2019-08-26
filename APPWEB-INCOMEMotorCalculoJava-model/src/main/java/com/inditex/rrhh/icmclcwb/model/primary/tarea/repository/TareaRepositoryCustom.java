package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaRepositoryCustom {

    void updateFechaFin(@NotNull final TareaDto tarea);
    
    void updateFechaInicioAndEstado(@NotNull final TareaDto tarea, @NotNull final EstadoTareaDto estado);

    void updateEstado(@NotNull final TareaDto tarea, @NotNull final EstadoTareaDto estado);

    void updateEstadoFinal(@NotNull final TareaDto tarea);
    
    List<IdTareaDto> findLimpieza();

}
