package com.inditex.rrhh.icmclcwb.api.app.run.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaRecolectarByAmbitoService {

    RunTareaDto run(@NotNull @Valid final RunTareaDto runTarea);
    
    RunTareaDto runPoC(@NotNull @Valid final RunTareaDto runTarea);

}
