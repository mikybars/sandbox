package com.inditex.rrhh.icmclcwb.api.app.run.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaMigrarComisionDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface RunTareaMigrarService {

  void run(@NotNull @Valid final RunTareaDto runTarea, List<TareaMigrarComisionDto> deleteMigracion);
}
