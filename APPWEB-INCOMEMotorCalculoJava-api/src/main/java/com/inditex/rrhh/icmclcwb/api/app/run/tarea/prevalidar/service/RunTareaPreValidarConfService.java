package com.inditex.rrhh.icmclcwb.api.app.run.tarea.prevalidar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaPrevalidarDto;

public interface RunTareaPreValidarConfService {

    void run(@NotNull @Valid final RunTareaPrevalidarDto runTareaPrevalidarDto);

}
