package com.inditex.rrhh.icmclcwb.api.app.run.programacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.RunProgramacionDTO;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunProgramacionService {

  List<RunProgramacionDTO> create();

  RunProgramacionDTO run(@NonNull @Valid final Long id);

}
