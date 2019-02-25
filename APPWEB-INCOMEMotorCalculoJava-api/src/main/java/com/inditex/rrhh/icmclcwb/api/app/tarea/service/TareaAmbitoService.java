package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaAmbitoService {

    List<TareaAmbitoDto> findByTarea(@Valid @NotNull final TareaDto tarea);

    List<TareaAmbitoDto> create(@Valid @NotNull @NotEmpty final List<TareaAmbitoDto> tareaAmbito,
            @NotNull final TareaDto tarea);

}
