package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresencia;

public interface TareaLocalizacionPersonaPresenciaRepositoryCustom {

    List<TareaLocalizacionPersonaPresencia> save(List<TareaLocalizacionPersonaPresencia> src);

    void updateActivo(@NotNull RunTareaDto runTareaDto);

    void updateActivoTotalizado(@NotNull RunTareaDto runTareaDto);

}
