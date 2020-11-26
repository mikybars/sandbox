package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionValidacionDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPrevalidacionValidacion;

public interface TareaPrevalidacionValidacionRepositoryCustom {

    List<TareaPrevalidacionValidacion> save(List<TareaPrevalidacionValidacion> src);

    void update(Integer idEstadoValidacion, Integer idTareaPrevalidacion, Integer idTipoValidacion, Long idTarea);

    TareaPrevalidacionValidacionDto findByIdTareaAndIdTareaPrevalidacionAndTipoValidacion(@NotNull Long idTarea,
            @NotNull Integer idTareaPrevalidacion, @NotNull Integer idTipoValidacion);

}
