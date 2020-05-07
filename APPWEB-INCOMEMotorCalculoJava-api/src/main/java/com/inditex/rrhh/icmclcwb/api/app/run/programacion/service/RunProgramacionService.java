package com.inditex.rrhh.icmclcwb.api.app.run.programacion.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.programacion.dto.RunProgramacionDto;

public interface RunProgramacionService {

    List<RunProgramacionDto> create();

    RunProgramacionDto run(@NotNull @Valid final Long id);

}
