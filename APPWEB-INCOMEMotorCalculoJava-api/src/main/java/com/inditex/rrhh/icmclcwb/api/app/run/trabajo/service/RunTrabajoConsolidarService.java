package com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoDto;

public interface RunTrabajoConsolidarService {

	RunTrabajoDto run(@Valid final RunTrabajoDto trabajoRun) throws Exception;

}