package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCalculoPersona;

public interface TareaCalculoPersonaRepositoryCustom {

    List<TareaCalculoPersona> save(List<TareaCalculoPersona> src);

    void mergePersonaCalculo(@NotNull RunTareaDto tareaDto);

}
