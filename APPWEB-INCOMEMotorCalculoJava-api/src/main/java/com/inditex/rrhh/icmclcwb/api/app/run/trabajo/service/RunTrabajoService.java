package com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoDto;

public interface RunTrabajoService {

    RunTrabajoDto run(@NotNull @Valid final RunTrabajoDto trabajoRun);

}