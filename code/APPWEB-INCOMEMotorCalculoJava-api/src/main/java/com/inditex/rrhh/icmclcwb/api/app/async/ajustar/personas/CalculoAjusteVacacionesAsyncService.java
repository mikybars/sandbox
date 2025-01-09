package com.inditex.rrhh.icmclcwb.api.app.async.ajustar.personas;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;
import org.springframework.scheduling.annotation.Async;

public interface CalculoAjusteVacacionesAsyncService {

  @Async("ajusteExecutor")
  CompletableFuture<Void> ajustar(@NonNull final AlgoritmoAjusteDto algoritmoAjuste, @NonNull final TareaDto tarea,
      @NonNull @NotEmpty final List<IdPersonaLocalDto> personas);

}
