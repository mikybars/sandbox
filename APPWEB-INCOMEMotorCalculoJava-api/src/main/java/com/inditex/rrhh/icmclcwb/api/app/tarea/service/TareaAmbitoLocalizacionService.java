package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaAmbitoLocalizacionService {

    List<TareaAmbitoLocalizacionDto> findByTarea(@Valid @NotNull final TareaDto tarea);
    
    List<TareaAmbitoLocalizacionDto> create(
            @Valid @NotNull @NotEmpty final List<TareaAmbitoLocalizacionDto> tareaAmbitoLocalizacion,
            @NotNull final TareaDto tarea);

}
