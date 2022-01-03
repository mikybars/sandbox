package com.inditex.rrhh.icmclcwb.api.app.run.programacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.RunProgramacionDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface RunProgramacionService {

  List<RunProgramacionDTO> create();

  RunProgramacionDTO run(@NotNull @Valid final Long id);

}
