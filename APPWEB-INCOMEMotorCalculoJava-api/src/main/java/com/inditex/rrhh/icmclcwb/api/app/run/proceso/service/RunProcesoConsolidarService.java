package com.inditex.rrhh.icmclcwb.api.app.run.proceso.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoDto;

public interface RunProcesoConsolidarService {

	RunProcesoDto run(@Valid final RunProcesoDto runProceso);

}