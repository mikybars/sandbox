package com.inditex.rrhh.icmclcwb.api.app.run.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface RunTareaPrevalidarDuranteService {

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param faseDto Some javadoc.
   */
  void run(@NotNull @Valid RunTareaDto runTareaDto,
      @NotNull @Valid FaseDto faseDto,
      @NotNull @Valid AccionDto accionDto);

}
