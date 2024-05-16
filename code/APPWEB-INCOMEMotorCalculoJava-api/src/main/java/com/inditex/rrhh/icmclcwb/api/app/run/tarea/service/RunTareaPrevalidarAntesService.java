package com.inditex.rrhh.icmclcwb.api.app.run.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface RunTareaPrevalidarAntesService {

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param faseDto Some javadoc.
   */
  void run(@NotNull @Valid RunTareaDto runTareaDto, @NotNull @Valid FaseDto faseDto);

}
