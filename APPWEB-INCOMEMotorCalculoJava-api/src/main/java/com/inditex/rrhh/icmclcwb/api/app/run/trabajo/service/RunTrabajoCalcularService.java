package com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoDto;

public interface RunTrabajoCalcularService {

	RunTrabajoDto run(@Valid final RunTrabajoDto runTrabajo) throws Exception;

}