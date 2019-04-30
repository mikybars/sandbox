package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacion;

public interface TareaLocalizacionRepositoryCustom {

    List<TareaLocalizacion> save(List<TareaLocalizacion> src);

    void mergeLocalizacion(@NotNull RunTareaDto tareaDto);

}
