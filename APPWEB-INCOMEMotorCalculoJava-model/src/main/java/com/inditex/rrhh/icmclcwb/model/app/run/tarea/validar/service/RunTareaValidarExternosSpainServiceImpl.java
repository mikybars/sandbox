package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarExternosSpainService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunPrevalidar;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component("externosSpainV1")
@Validated
public class RunTareaValidarExternosSpainServiceImpl implements RunPrevalidar {

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  @Autowired
  private RunTareaAmbitoValidarExternosSpainService runTareaAmbitoValidarExternosSpainService;

  @Autowired
  private AccionService accionService;

  @Override
  public CompletableFuture<List<ValidacionDto>> execute(
      @NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaFaseAccionDto tareaFaseAccion) {
    final TareaDto tareaDto = runTarea.getTarea();
    this.tareaFaseAccionService.updateFechaInicio(tareaFaseAccion);
    final List<ValidacionDto> validaciones = runTarea.getTarea()
        .getAmbito()
        .stream()
        .filter(a -> Boolean.TRUE.equals(
            this.accionService.findByIdAccionAndIdOrigenAndStdIdLegEnt(tareaFaseAccion.getIdAccion(),
                a.getCclIdOrigen(),
                tareaDto.getStdIdLegEnt())))
        .map(item -> this.runTareaAmbitoValidarExternosSpainService.execute(runTarea, item, tareaFaseAccion))
        .collect(Collectors.toList());
    if (validaciones.isEmpty()) {
      this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
          EstadoTareaFaseAccionEnum.NO_EJECUTADA.getDto());
      return CompletableFuture.completedFuture(validaciones);
    }
    if (validaciones.stream()
        .filter(e -> e.getResult().equals(Boolean.FALSE))
        .collect(Collectors.toList())
        .isEmpty()) {
      this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion, EstadoTareaFaseAccionEnum.OK.getDto());
    }
    return CompletableFuture.completedFuture(validaciones);
  }

}
