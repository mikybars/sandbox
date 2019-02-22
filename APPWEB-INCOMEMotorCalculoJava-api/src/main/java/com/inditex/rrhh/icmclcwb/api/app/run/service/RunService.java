package com.inditex.rrhh.icmclcwb.api.app.run.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoDto;

public interface RunService {

	RunProcesoDto runProceso(@NotNull @Positive final Long id);

}