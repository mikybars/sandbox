package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaRepositoryCustom {

    void updateEstadoFinal(@NotNull TareaDto tareaDto);

}
