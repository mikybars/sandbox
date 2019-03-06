package com.inditex.rrhh.icmclcwb.api.app.run.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;

public interface RunService {

    RunTrabajoDto runTrabajo(@NotNull @Positive final Long id);

    RunTareaDto runTarea(@NotNull @Positive final Long id);

}
