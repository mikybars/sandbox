package com.inditex.rrhh.icmclcwb.model.app.calcular;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.scheduling.annotation.Async;

/**
 * Interface for non-blocking validations. These validations execute without stopping the calculation process, allowing multiple validations
 * to run and consolidate results into a single email.
 */
public interface RunValidacionNoBloqueante {

  /**
   * Execute a non-blocking validation. Unlike RunPrevalidar, this validation does not throw exceptions or stop the calculation flow.
   *
   * @param runTarea The task execution context
   * @param tareaFaseAccion The phase action being validated
   * @return A CompletableFuture containing validation results
   */
  @Async("validacionExecutor")
  CompletableFuture<List<ValidacionDto>> execute(@NotNull @Valid RunTareaDto runTarea,
      @NotNull @Valid TareaFaseAccionDto tareaFaseAccion);

}
