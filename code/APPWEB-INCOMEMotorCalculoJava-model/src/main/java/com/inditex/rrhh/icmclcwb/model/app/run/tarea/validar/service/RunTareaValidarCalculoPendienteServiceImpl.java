package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarCalculoPendienteService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunValidacionNoBloqueante;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component("validarCalculoPendienteV1")
@Validated
public class RunTareaValidarCalculoPendienteServiceImpl implements RunValidacionNoBloqueante {

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  @Autowired
  private AccionService accionService;

  @Autowired
  private RunTareaAmbitoValidarCalculoPendienteService runTareaAmbitoValidarCalculoPendienteService;

  @Override
  public CompletableFuture<List<ValidacionDto>> execute(@NotNull @Valid RunTareaDto runTarea,
      @NotNull @Valid TareaFaseAccionDto tareaFaseAccion) {
    final TareaDto tareaDto = runTarea.getTarea();
    this.tareaFaseAccionService.updateFechaInicio(tareaFaseAccion);
    final List<ValidacionDto> validaciones = runTarea.getTarea()
        .getAmbito()
        .stream()
        .filter(a -> Boolean.TRUE
            .equals(this.accionService.findByIdAccionAndIdOrigenAndStdIdLegEnt(tareaFaseAccion.getIdAccion(),
                a.getCclIdOrigen(), tareaDto.getStdIdLegEnt())))
        .map(item -> this.runTareaAmbitoValidarCalculoPendienteService
            .execute(runTarea, item, tareaFaseAccion))
        .toList();
    if (validaciones.isEmpty()) {
      this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
          EstadoTareaFaseAccionEnum.NO_EJECUTADA.getDto());
      return CompletableFuture.completedFuture(validaciones);
    }

    this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion, EstadoTareaFaseAccionEnum.OK.getDto());
    return CompletableFuture.completedFuture(validaciones);
  }
}
