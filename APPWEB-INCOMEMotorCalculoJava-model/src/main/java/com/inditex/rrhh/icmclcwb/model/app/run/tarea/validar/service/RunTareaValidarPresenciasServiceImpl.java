package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarPresenciasService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunPrevalidar;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component("presenciasV1")
@Validated
public class RunTareaValidarPresenciasServiceImpl implements RunPrevalidar {

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  @Autowired
  private RunTareaAmbitoValidarPresenciasService runTareaAmbitoValidarPresenciasService;

  @Autowired
  private AccionService accionService;

  @Autowired
  private Logger log;

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
        .map(item -> this.runTareaAmbitoValidarPresenciasService
            .execute(runTarea, item, tareaFaseAccion))
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
    } else {
      validaciones.stream().filter(e -> e.getResult().equals(Boolean.FALSE))
          .forEach(e -> {
            this.log.error(
                new StringBuilder("Trabajo[")
                    .append(runTarea.getTarea().getIdTrabajo())
                    .append("]")
                    .append("Tarea[")
                    .append(runTarea.getTarea().getId())
                    .append("] :: ")
                    .append("Horas PTR: ")
                    .append(e.getPtr())
                    .append(", Horas Comis: ")
                    .append(e.getComis()).toString());
          });
    }

    return CompletableFuture.completedFuture(validaciones);
  }

}
