package com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoDto;

public interface RunTrabajoRecolectarService {

    RunTrabajoDto run(@Valid final RunTrabajoDto runTrabajo) throws IcmclcwbException;

    RunTrabajoDto runNew(@Valid final RunTrabajoDto runTrabajo) throws IcmclcwbException;

}
