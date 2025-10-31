package com.inditex.rrhh.icmclcwb.api.app.run.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Service for executing grouped non-blocking validations. This service executes multiple validations in parallel, waits for all to
 * complete, and sends a single consolidated email with all validation results.
 */
public interface RunValidacionesAgrupadasService {

  /**
   * Execute grouped non-blocking validations.
   *
   * @param runTareaDto The task execution context
   * @param faseDto The phase being executed
   * @return List of failed validations (with persons affected)
   */
  List<ValidacionDto> ejecutarValidacionesNoBloqueantes(@NotNull @Valid RunTareaDto runTareaDto,
      @NotNull @Valid FaseDto faseDto);

}
