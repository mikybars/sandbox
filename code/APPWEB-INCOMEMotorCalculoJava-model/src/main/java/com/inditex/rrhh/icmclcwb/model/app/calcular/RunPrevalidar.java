package com.inditex.rrhh.icmclcwb.model.app.calcular;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.scheduling.annotation.Async;

public interface RunPrevalidar {

  /**
   * Some javadoc.
   *
   * @param runTarea Some javadoc.
   * @param tareaFaseAccion Some javadoc.
   */
  @Async("validacionExecutor")
  CompletableFuture<List<ValidacionDto>> execute(@NotNull @Valid RunTareaDto runTarea,
      @NotNull @Valid TareaFaseAccionDto tareaFaseAccion);

}
