package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresenciaSeccion;

public interface TareaLocalizacionPersonaPresenciaSeccionRepositoryCustom {

    List<TareaLocalizacionPersonaPresenciaSeccion> save(List<TareaLocalizacionPersonaPresenciaSeccion> src);

    void updateActivo(@NotNull RunTareaDto runTareaDto);

}
