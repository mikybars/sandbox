package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarExportacionFranciaService;
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

@Component("validarExportacionFranciaV1")
@Validated
public class RunTareaValidarExportacionFranciaServiceImpl implements RunPrevalidar {

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  @Autowired
  private RunTareaAmbitoValidarExportacionFranciaService runTareaAmbitoValidarExportacionFranciaService;

  @Autowired
  private AccionService accionService;

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
        .map(item -> this.runTareaAmbitoValidarExportacionFranciaService
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
    }
    return CompletableFuture.completedFuture(validaciones);
  }

}
