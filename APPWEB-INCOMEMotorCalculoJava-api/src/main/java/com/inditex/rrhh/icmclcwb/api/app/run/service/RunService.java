package com.inditex.rrhh.icmclcwb.api.app.run.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoDto;

public interface RunService {

	RunTrabajoDto runTrabajo(@NotNull @Positive final Long id) throws Exception;

}