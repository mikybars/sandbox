package com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service;

import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.annotation.TrabajoValidator;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface RunTrabajoService {

  RunTrabajoDto run(@NotNull @Valid @TrabajoValidator final RunTrabajoDto runTrabajo);

}
