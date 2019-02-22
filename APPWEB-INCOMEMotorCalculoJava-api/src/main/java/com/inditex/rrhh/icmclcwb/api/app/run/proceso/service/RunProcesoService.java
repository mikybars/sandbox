package com.inditex.rrhh.icmclcwb.api.app.run.proceso.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoDto;

public interface RunProcesoService {

    RunProcesoDto run(@NotNull @Valid final RunProcesoDto runProceso);

}