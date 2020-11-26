package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionDto;

public interface TareaPrevalidacionService {

    void save(@Valid @NotNull TareaPrevalidacionDto src, @Valid @NotNull TareaDto tarea);

    TareaPrevalidacionDto create(@Valid @NotNull TareaDto tarea);

    void updateFechaFin(@Valid @NotNull TareaPrevalidacionDto tareaPrevalidacionDto);

    void updateEstado(@Valid @NotNull TareaPrevalidacionDto tareaPrevalidacionDto,
            @Valid @NotNull EstadoTareaPrevalidacionDto estado);

    void send(@Valid @NotNull TareaPrevalidacionDto prevalidacionDto);

}
