package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunValidacionesAgrupadasService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunPrevalidar;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * Wrapper component that integrates grouped non-blocking validations into the existing validation flow
 */
@Component("validacionesAgrupadasV1")
@Validated
public class RunTareaValidacionesAgrupadasWrapper implements RunPrevalidar {

  @Autowired
  private RunValidacionesAgrupadasService runValidacionesAgrupadasService;

  @Autowired
  private TareaFaseService tareaFaseService;

  @Override
  public CompletableFuture<List<ValidacionDto>> execute(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaFaseAccionDto tareaFaseAccion) {

    final TareaFaseDto tareaFaseDto = this.tareaFaseService
        .findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
            tareaFaseAccion.getIdTareaFase().intValue());

    final FaseDto faseDto = new FaseDto(tareaFaseDto.getIdFase());

    this.runValidacionesAgrupadasService.ejecutarValidacionesNoBloqueantes(runTarea, faseDto);

    return CompletableFuture.completedFuture(Collections.emptyList());
  }

}
