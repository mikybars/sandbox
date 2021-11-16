package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarPresenciasExternosService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaAmbitoValidarPresenciasExternosServiceImpl implements
    RunTareaAmbitoValidarPresenciasExternosService {

  @Autowired
  private ValidacionMapper validacionMapper;

  @Autowired
  private TareaLocalizacionPersonaPresenciaAsyncService tareaLocalizacionPersonaPresenciaAsyncService;

  @Override
  public ValidacionDto execute(
      @Valid final RunTareaDto runTarea,
      @Valid final TareaAmbitoDto tareaAmbito,
      @Valid final TareaFaseAccionDto tareaFaseAccion) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final CompletableFuture<Void> cfUpdate = this.tareaLocalizacionPersonaPresenciaAsyncService
        .updateActivoPersonasExternas(runTarea);
    AsyncUtils.exceptionally(cfUpdate, cf);

    AsyncUtils.waitAllOfIsOk(cf, cf);

    return this.validacionMapper.booleanToValidacionDto(tareaAmbito, tareaFaseAccion, true);
  }

}
