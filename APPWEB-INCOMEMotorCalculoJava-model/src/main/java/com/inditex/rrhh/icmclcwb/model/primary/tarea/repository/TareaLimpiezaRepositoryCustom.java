package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TareaLimpiezaRepositoryCustom {

    void mergeLimpieza(@NotNull TareaDto tareaDto, TrabajoDto trabajoDto);

}
