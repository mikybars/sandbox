package com.inditex.rrhh.icmclcwb.model.app.async.ajuste.personas;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.personas.CalculoAjusteAntiguedadService;
import com.inditex.rrhh.icmclcwb.api.app.async.ajustar.personas.CalculoAjusteAntiguedadAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CalculoAjusteAntiguedadAsyncServiceImpl implements CalculoAjusteAntiguedadAsyncService {

  @Autowired
  private CalculoAjusteAntiguedadService calculoAjusteAntiguedadService;

  @Override
  public CompletableFuture<Void> ajustar(@NonNull final AlgoritmoAjusteDto algoritmoAjuste,
      @NonNull final TareaDto tarea,
      @NonNull @NotEmpty final List<IdPersonaLocalDto> personas) {
    this.calculoAjusteAntiguedadService.ajustar(algoritmoAjuste, tarea, personas);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
