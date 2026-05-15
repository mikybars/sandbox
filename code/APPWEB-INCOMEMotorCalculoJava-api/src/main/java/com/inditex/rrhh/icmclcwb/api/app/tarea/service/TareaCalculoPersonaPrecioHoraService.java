package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalSimpleDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import jakarta.validation.constraints.NotNull;
import org.springframework.scheduling.annotation.Async;

public interface TareaCalculoPersonaPrecioHoraService {

  List<IdPersonaLocalSimpleDto> getIdsPersonasCalculoPrecioHoraByTareaAndAmbito(@NotNull RunTareaDto runTareaDto,
      @NotNull TareaAmbitoDto ambitoDto);

  @Async("calculoExecutor")
  CompletableFuture<Void> calcularPrecioHora(@NotNull RunTareaDto tunTarea, @NotNull TareaAmbitoDto ambitoDto,
      @NotNull List<IdPersonaLocalSimpleDto> personas);

}
