/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionValidacionDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confprevalid.ConfPreValidResultItemDto;

public interface TareaPrevalidacionValidacionService {

    void save(@Valid @NotNull TareaPrevalidacionValidacionDto src, @Valid @NotNull TareaDto tarea);

    void update(TareaPrevalidacionValidacionDto tareaPrevalidacionValidacionDto, @Valid @NotNull TareaDto tarea,
            Integer idEstadoValidacion);

    TareaPrevalidacionValidacionDto findByIdTareaAndIdTareaPrevalidacionAndTipoValidacion(@NotNull Long idTarea,
            @NotNull Integer idPrevalidacion, @NotNull Integer idTipoValidacion);

    void saveConfPreValidResultItemDto(@Valid @NotNull List<ConfPreValidResultItemDto> src,
            @Valid @NotNull TareaPrevalidacionDto tareaPrevalidacionDto);

}
