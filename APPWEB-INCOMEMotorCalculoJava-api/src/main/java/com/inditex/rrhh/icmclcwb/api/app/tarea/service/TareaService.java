package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TareaService {

    TareaDto find(@NotNull @Positive final Long id);
    
    TareaDto create(@Valid final TareaDto tarea);

    List<TareaDto> create(@Valid @NotNull final TrabajoDto trabajo);

}