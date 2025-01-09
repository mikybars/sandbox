package com.inditex.rrhh.icmclcwb.api.app.run.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaPrevalidarDuranteService {

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param faseDto Some javadoc.
   */
  void run(@NonNull @Valid RunTareaDto runTareaDto,
      @NonNull @Valid FaseDto faseDto,
      @NonNull @Valid AccionDto accionDto);

}
