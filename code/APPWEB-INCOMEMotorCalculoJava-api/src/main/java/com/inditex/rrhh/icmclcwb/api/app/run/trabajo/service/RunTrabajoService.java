package com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service;

import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.annotation.TrabajoValidator;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTrabajoService {

  RunTrabajoDto run(@NonNull @Valid @TrabajoValidator final RunTrabajoDto runTrabajo);

}
