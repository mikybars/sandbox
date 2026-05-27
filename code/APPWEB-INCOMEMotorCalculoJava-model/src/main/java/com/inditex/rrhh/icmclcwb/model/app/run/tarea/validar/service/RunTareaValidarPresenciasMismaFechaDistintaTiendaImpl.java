package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarPresenciasMismaFechaDistintaTiendaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunValidacionNoBloqueante;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component("validarPresenciasMismaFechaDistintaTiendaV1")
@Validated
@AllArgsConstructor
public class RunTareaValidarPresenciasMismaFechaDistintaTiendaImpl implements RunValidacionNoBloqueante {

  private final TareaFaseAccionService tareaFaseAccionService;

  private final RunTareaAmbitoValidarPresenciasMismaFechaDistintaTiendaService runTareaAmbitoValidarPresenciasMismaFechaDistintaTiendaService;

  private final AccionService accionService;

  @Override
  public CompletableFuture<List<ValidacionDto>> execute(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaFaseAccionDto tareaFaseAccion) {
    final TareaDto tareaDto = runTarea.getTarea();
    this.tareaFaseAccionService.updateFechaInicio(tareaFaseAccion);

    final List<ValidacionDto> validaciones = runTarea.getTarea()
        .getAmbito()
        .stream()
        .filter(a -> Boolean.TRUE
            .equals(this.accionService.findByIdAccionAndIdOrigenAndStdIdLegEnt(tareaFaseAccion.getIdAccion(),
                a.getCclIdOrigen(), tareaDto.getStdIdLegEnt())))
        .map(item -> this.runTareaAmbitoValidarPresenciasMismaFechaDistintaTiendaService
            .execute(runTarea, item, tareaFaseAccion))
        .toList();

    if (validaciones.isEmpty()) {
      this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
          EstadoTareaFaseAccionEnum.NO_EJECUTADA.getDto());
      return CompletableFuture.completedFuture(validaciones);
    }

    if (validaciones.stream().noneMatch(e -> e.getResult().equals(Boolean.FALSE))) {
      this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion, EstadoTareaFaseAccionEnum.OK.getDto());
    }
    return CompletableFuture.completedFuture(validaciones);
  }
}
