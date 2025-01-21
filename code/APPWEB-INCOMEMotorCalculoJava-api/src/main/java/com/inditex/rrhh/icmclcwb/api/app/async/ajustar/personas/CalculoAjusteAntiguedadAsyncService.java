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
import jakarta.validation.constraints.NotNull;
import org.springframework.scheduling.annotation.Async;

public interface CalculoAjusteAntiguedadAsyncService {

  @Async("ajusteExecutor")
  CompletableFuture<Void> ajustar(@NotNull final AlgoritmoAjusteDto algoritmoAjuste, @NotNull final TareaDto tarea,
      @NotNull @NotEmpty final List<IdPersonaLocalDto> personas);

}
