package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TareaService {

    TareaDto save(@Valid final TareaDto tarea);

    TareaDto find(@NotNull @Positive final Long id);

    TareaDto create(@Valid final TareaDto tarea);

    List<TareaDto> create(@Valid @NotNull final TrabajoDto trabajo);

    List<TareaDto> findByTrabajoId(@Valid Long id);

    void updateFechaFin(@NotNull final TareaDto tarea);
    
    void updateFechaInicioAndEstado(@NotNull final TareaDto tarea, @NotNull final EstadoTareaDto estado);

    void updateEstado(@NotNull final TareaDto tarea, @NotNull final EstadoTareaDto estado);

    void updateEstadoFinal(@Valid final TareaDto tarea);
    
    List<IdTareaDto> findLimpieza();

}