package com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.annotation.TrabajoValidator;

public interface RunTrabajoService {

    RunTrabajoDto run(@NotNull @Valid @TrabajoValidator final RunTrabajoDto runTrabajo);

}