package com.inditex.rrhh.icmclcwb.api.app.run.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

@Deprecated
public interface RunTareaRecolectarByPoCService {

    RunTareaDto run(@NotNull @Valid final RunTareaDto runTarea);

}
