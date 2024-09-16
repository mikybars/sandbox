package com.inditex.rrhh.icmclcwb.api.app.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import jakarta.validation.Valid;
import org.springframework.scheduling.annotation.Async;

@Async
public interface PtrAsyncService {

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<PresenciaOrigenDto> findPresenciasOrigenAndFecha(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<PresenciaOrigenDto> findPresenciasOrigenAndFechaEs(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

}
