package com.inditex.rrhh.icmclcwb.model.app.async.ajuste.personas;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.personas.CalculoAjusteVacacionesService;
import com.inditex.rrhh.icmclcwb.api.app.async.ajustar.personas.CalculoAjusteVacacionesAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CalculoAjusteVacacionesAsyncServiceImpl implements CalculoAjusteVacacionesAsyncService {

  @Autowired
  private CalculoAjusteVacacionesService calculoAjusteVacacionesService;

  @Override
  public CompletableFuture<Void> ajustar(@NotNull final AlgoritmoAjusteDto algoritmoAjuste,
      @NotNull final TareaDto tarea,
      @NotNull @NotEmpty final List<IdPersonaLocalDto> personas) {
    this.calculoAjusteVacacionesService.ajustar(algoritmoAjuste, tarea, personas);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
