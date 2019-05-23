package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresencia;

public interface TareaLocalizacionPresenciaRepositoryCustom {

    List<TareaLocalizacionPresencia> save(List<TareaLocalizacionPresencia> src);

    void updateActivo(@NotNull RunTareaDto runTarea);

    void compensar(@NotNull RunTareaDto runTarea);

}
