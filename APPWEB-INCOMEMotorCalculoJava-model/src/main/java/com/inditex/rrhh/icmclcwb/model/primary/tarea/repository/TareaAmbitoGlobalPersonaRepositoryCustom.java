package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalPersona;

public interface TareaAmbitoGlobalPersonaRepositoryCustom {

    List<TareaAmbitoGlobalPersona> save(List<TareaAmbitoGlobalPersona> src);

    void mergePersona(@NotNull RunTareaDto tareaDto);

}
