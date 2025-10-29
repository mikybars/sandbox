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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * Wrapper component that integrates grouped non-blocking validations into the existing validation flow.
 */
@Slf4j
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

    log.info("RunTareaValidacionesAgrupadasWrapper.execute - Inicio - IdTarea: {}, IdTareaFase: {}",
        runTarea.getTarea().getId(), tareaFaseAccion.getIdTareaFase());

    log.debug("RunTareaValidacionesAgrupadasWrapper.execute - Parametros completos - RunTarea: {}, TareaFaseAccion: {}",
        runTarea, tareaFaseAccion);

    final TareaFaseDto tareaFaseDto = this.tareaFaseService
        .findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
            tareaFaseAccion.getIdTareaFase().intValue());

    if (tareaFaseDto == null) {
      log.error("RunTareaValidacionesAgrupadasWrapper.execute - TareaFaseDto es NULL - IdTarea: {}, IdTareaFase: {}",
          runTarea.getTarea().getId(), tareaFaseAccion.getIdTareaFase());
      throw new IllegalStateException(
          String.format("No se encontró TareaFaseDto para IdTarea: %s, IdTareaFase: %s",
              runTarea.getTarea().getId(), tareaFaseAccion.getIdTareaFase()));
    }

    log.info("RunTareaValidacionesAgrupadasWrapper.execute - TareaFaseDto encontrado - IdFase: {}",
        tareaFaseDto.getIdFase());

    final FaseDto faseDto = new FaseDto(tareaFaseDto.getIdFase());

    log.debug("RunTareaValidacionesAgrupadasWrapper.execute - Ejecutando validaciones no bloqueantes - FaseDto: {}",
        faseDto);

    this.runValidacionesAgrupadasService.ejecutarValidacionesNoBloqueantes(runTarea, faseDto);

    log.info("RunTareaValidacionesAgrupadasWrapper.execute - Fin - IdTarea: {}",
        runTarea.getTarea().getId());

    return CompletableFuture.completedFuture(Collections.emptyList());
  }

}
