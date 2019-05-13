package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaSeccionPresencia;

public interface TareaLocalizacionPersonaSeccionPresenciaRepositoryCustom {

    List<TareaLocalizacionPersonaSeccionPresencia> save(List<TareaLocalizacionPersonaSeccionPresencia> src);

    void updateActivo(@NotNull RunTareaDto runTareaDto);

}
