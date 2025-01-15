package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaMigrarComisionDto;

import jakarta.validation.constraints.NotNull;

public interface TareaMigrarService {

  /**
   * Finds the commission calculation for a given tarea.
   *
   * @param tarea The task details.
   * @return A list of commission migration tasks.
   */
  List<TareaMigrarComisionDto> findCalculoComisionByTareaActual(@NotNull TareaDto tarea);

  /**
   * Migrates the commission calculation for the given task.
   *
   * @param runTareaDto The details of the task to run.
   */
  void migrarCalculoComision(RunTareaDto runTareaDto);
}
