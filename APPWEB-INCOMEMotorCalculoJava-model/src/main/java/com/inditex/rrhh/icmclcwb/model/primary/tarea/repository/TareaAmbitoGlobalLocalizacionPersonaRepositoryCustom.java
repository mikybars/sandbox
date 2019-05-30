package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersona;

public interface TareaAmbitoGlobalLocalizacionPersonaRepositoryCustom {

    List<TareaAmbitoGlobalLocalizacionPersona> save(List<TareaAmbitoGlobalLocalizacionPersona> src);

    void mergePersonaLocalizacion(@NotNull final RunTareaDto tareaDto);

}
