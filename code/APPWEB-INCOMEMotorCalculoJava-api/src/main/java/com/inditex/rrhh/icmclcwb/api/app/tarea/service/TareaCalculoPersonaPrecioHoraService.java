package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import jakarta.validation.constraints.NotNull;

public interface TareaCalculoPersonaPrecioHoraService {

  List<IdPersonaLocalDto> getIdsPersonasCalculoPrecioHoraByTareaAndAmbito(@NotNull RunTareaDto runTareaDto,
      @NotNull TareaAmbitoDto ambitoDto);

  CompletableFuture<Void> calcularPrecioHora(@NotNull RunTareaDto tunTarea, @NotNull TareaAmbitoDto ambitoDto,
      @NotNull List<IdPersonaLocalDto> personas);

}
