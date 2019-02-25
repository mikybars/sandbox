package com.inditex.rrhh.icmclcwb.api.app.run.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;

public interface RunService {

    RunProcesoDto runProceso(@NotNull @Positive final Long id);

    RunTrabajoDto runTrabajo(@NotNull @Positive final Long id);

    RunTareaDto runTarea(@NotNull @Positive final Long id);

}
