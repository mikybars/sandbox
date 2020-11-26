/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionValidacionDto;

public interface TareaPrevalidacionValidacionService {

    void save(@Valid @NotNull TareaPrevalidacionValidacionDto src, @Valid @NotNull TareaDto tarea);

    void create(@Valid @NotNull TareaDto tarea, @NotNull final Integer idTipoEstadoValidacion,
            @NotNull final TareaPrevalidacionDto tareaPrevalidacionDto);

    void update(TareaPrevalidacionValidacionDto tareaPrevalidacionValidacionDto, @Valid @NotNull TareaDto tarea,
            Integer idEstadoValidacion);

    TareaPrevalidacionValidacionDto findByIdTareaAndIdTareaPrevalidacionAndTipoValidacion(@NotNull Long idTarea,
            @NotNull Integer idPrevalidacion, @NotNull Integer idTipoValidacion);

}
