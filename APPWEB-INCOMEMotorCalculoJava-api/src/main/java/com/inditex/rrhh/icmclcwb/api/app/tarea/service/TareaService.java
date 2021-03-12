package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.limpieza.dto.RunMantenimientoLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TareaService {

    TareaDto save(@Valid @NotNull final TareaDto tarea);

    TareaDto find(@NotNull @Positive final Long id);

    TareaDto create(@Valid @NotNull final TareaDto tarea);

    List<TareaDto> create(@Valid @NotNull final TrabajoDto trabajo);

    List<TareaDto> findByTrabajoId(@NotNull @Positive final Long id);

    void updateFechaFin(@Valid @NotNull final TareaDto tarea);

    void updateFechaInicioAndEstado(@Valid @NotNull final TareaDto tarea, @Valid @NotNull final EstadoTareaDto estado);

    void updateEstado(@Valid @NotNull final TareaDto tarea, @Valid @NotNull final EstadoTareaDto estado);

    void updateEstadoFinal(@Valid @NotNull final TareaDto tarea);

    RunMantenimientoLimpiezaDto findLimpieza();

    RunMantenimientoLimpiezaDto findLimpiezaByIdTarea(@NotNull @Positive final Long idTarea);

    TareaDto findByIdLimpieza(@NotNull @Positive final Long idLimpieza);

}
