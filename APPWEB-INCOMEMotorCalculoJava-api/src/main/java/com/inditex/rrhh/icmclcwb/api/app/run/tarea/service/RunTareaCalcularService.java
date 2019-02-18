package com.inditex.rrhh.icmclcwb.api.app.run.tarea.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTareaDto;

public interface RunTareaCalcularService {

	RunTareaDto run(@Valid final RunTareaDto runTarea);

}